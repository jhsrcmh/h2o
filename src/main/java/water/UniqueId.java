package water;

import com.google.gson.JsonObject;
import water.api.DocGen;
import water.api.Request.API;
import water.api.Request.Default;

import java.util.UUID;

/**
 * Some properties to mix in to Frame, Model and such to make them uniquely identifyable.
 * That is, we want to distinguish between different instances of a Model that have the
 * same key over time.
 */

public class UniqueId extends Iced {
  static final int API_WEAVER = 1;
  static public DocGen.FieldDoc[] DOC_FIELDS;

  @API(help="The keycreation timestamp for the object (if it's not null).", required=false, filter=Default.class, json=true)
  private String key = null;

  @API(help="The creation timestamp for the object.", required=false, filter=Default.class, json=true)
  private long creation_epoch_time_millis = -1L;

  @API(help="The id for the object.", required=false, filter=Default.class, json=true)
  private String id = null;


  public UniqueId(Key key) {
    if (null != key)
      this.key = key.toString();
    this.creation_epoch_time_millis = System.currentTimeMillis();
    this.id = UUID.randomUUID().toString();
  }

  /**
   * ONLY to be used to deserializing persisted instances.
   */
  public UniqueId(String key, long creation_epoch_time_millis, String id) {
    this.key = key;
    this.creation_epoch_time_millis = creation_epoch_time_millis;
    this.id = id;
  }

  public String getKey() {
    return this.key;
  }

  public long getCreationEpochTimeMillis() {
    return this.creation_epoch_time_millis;
  }

  public String getId() {
    return this.id;
  }

  public JsonObject toJSON() {
    JsonObject result = new JsonObject();
    result.addProperty("key", this.getKey());
    result.addProperty("creation_epoch_time_millis", this.getCreationEpochTimeMillis());
    result.addProperty("id", this.getId());
    return result;
  }

  public boolean equals(Object o) {
    if (!(o instanceof UniqueId))
      return false;

    UniqueId other = (UniqueId)o;

    // NOTE: we must call this.getId() because subclasses can define the id in a way that's dynamic.
    return
      (this.creation_epoch_time_millis == other.creation_epoch_time_millis) &&
      (this.getId() != null) &&
      (this.getId().equals(other.getId()));
  }

  public int hashCode() {
    return 17 +
      37 * Long.valueOf(this.creation_epoch_time_millis).hashCode() +
      37 * this.getId().hashCode();
  }
}
