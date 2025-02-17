package water.fvec;

import java.util.Iterator;

import water.Futures;

/** Helper to provide access to package
 * hidden methods and attributes.
 */
public class ChunkSplitter {
  /** Reset len fields of given chunk */
  public static NewChunk resetLen(NewChunk nc) {
    nc._len = nc._len2 = 0;
    return nc;
  }

  /** Extract portion of given chunk into given output chunk. */
  public static void extractChunkPart(Chunk ic, Chunk oc, int startRow, int nrows, Futures fs) {
    NewChunk dst = new NewChunk(oc);
    dst._len = dst._len2 = 0;
    NewChunk src = new NewChunk(ic);
    src = ic.inflate_impl(src);
    assert src._len2 == ic._len;
    // Iterate over values skip all 0
    int remain = nrows;
    Iterator<NewChunk.Value> it = src.values(startRow,startRow+nrows);
    int off = startRow-1;
    while(it.hasNext()) {
      NewChunk.Value v = it.next();
      final int rid = v.rowId0();
      assert  rid < startRow+nrows;
      int add = rid - off; // number of values to add
      off = rid;
      dst.addZeros(add-1); // append (add-1) zeros
      v.add2Chunk(dst);    // followed by a value
      remain -= add;
      assert remain >= 0;
    }
    // Handle case when last added value is followed by zeros till startRow+nrows
    dst.addZeros(remain);

    assert dst._len2 == oc._len : "NewChunk.dst.len2 = " + dst._len2 + ", oc._len = " + oc._len;
    dst.close(dst.cidx(),fs);

    return ;
  }
}
