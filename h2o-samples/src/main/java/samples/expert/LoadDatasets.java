package samples.expert;

import water.*;
import water.api.FrameSplitPage;
import water.fvec.Frame;
import water.fvec.RebalanceDataSet;
import water.util.Log;

import java.util.Set;

/**
 * Loads all datasets from smalldata folder for testing purposes
 */
public class LoadDatasets extends Job {
  public static void main(String[] args) throws Exception {
    Class job = LoadDatasets.class;
    samples.launchers.CloudLocal.launch(job, 1);
//    samples.launchers.CloudProcess.launch(job, 2);
    //samples.launchers.CloudConnect.launch(job, "localhost:54321");
//    samples.launchers.CloudRemote.launchIPs(job, "192.168.1.161", "192.168.1.162", "192.168.1.163", "192.168.1.164");
//    samples.launchers.CloudRemote.launchIPs(job, "192.168.1.161", "192.168.1.163", "192.168.1.164");
    //samples.launchers.CloudRemote.launchEC2(job, 4);
  }

  void load() {
    TestUtil.parseFromH2OFolder("smalldata/./logreg/prostate.csv");
    TestUtil.parseFromH2OFolder("smalldata/./logreg/prostate_long.csv.gz");
    TestUtil.parseFromH2OFolder("smalldata/./mnist/test.csv.gz");
    TestUtil.parseFromH2OFolder("smalldata/./mnist/train.csv.gz");
    TestUtil.parseFromH2OFolder("smalldata/./cars.csv");
    TestUtil.parseFromH2OFolder("smalldata/./iris/iris.csv");
    TestUtil.parseFromH2OFolder("smalldata/test/classifier/multi_class.train.csv");
    TestUtil.parseFromH2OFolder("smalldata/test/classifier/multi_class.test.csv");
    TestUtil.parseFromH2OFolder("smalldata/./covtype/covtype.20k.data");
    TestUtil.parseFromH2OFolder("smalldata/./1_100kx7_logreg.data.gz");
    TestUtil.parseFromH2OFolder("smalldata/./2_100kx7_logreg.data.gz");
    TestUtil.parseFromH2OFolder("smalldata/./AID362red_test.csv.gz");
    TestUtil.parseFromH2OFolder("smalldata/./airlines/AirlinesTest.csv.zip");
    TestUtil.parseFromH2OFolder("smalldata/./airlines/AirlinesTrain.csv.zip");
    TestUtil.parseFromH2OFolder("smalldata/./airlines/allyears2k.zip");
    TestUtil.parseFromH2OFolder("smalldata/./airlines/allyears2k_headers.zip");
//    TestUtil.parseFromH2OFolder("smalldata/./airlines/hiveallyears2k/04c40d7c-33c8-486c-8f08-e24ebb8832ea_000000");
//    TestUtil.parseFromH2OFolder("smalldata/./airlines/hiveallyears2k/04c40d7c-33c8-486c-8f08-e24ebb8832ed_000000");
//    TestUtil.parseFromH2OFolder("smalldata/./airlines/hiveallyears2k/04c40d7c-33c8-486c-8f08-e24ebb8832ed_000001");
//    TestUtil.parseFromH2OFolder("smalldata/./airlines/hiveallyears2k/04c40d7c-33c8-486c-8f08-e24ebb8832ed_000002");
//    TestUtil.parseFromH2OFolder("smalldata/./airlines/hiveallyears2k/04c40d7c-33c8-486c-8f08-e24ebb8832ed_000005");
//    TestUtil.parseFromH2OFolder("smalldata/./allstate/claim_prediction_dict.html");
    TestUtil.parseFromH2OFolder("smalldata/./allstate/claim_prediction_train_set_10000.csv.gz");
    TestUtil.parseFromH2OFolder("smalldata/./allstate/claim_prediction_train_set_10000_bool.csv.gz");
    TestUtil.parseFromH2OFolder("smalldata/./allstate/claim_prediction_train_set_10000_int.csv.gz");
    TestUtil.parseFromH2OFolder("smalldata/./auto.csv");
    TestUtil.parseFromH2OFolder("smalldata/./badchars.csv");
    TestUtil.parseFromH2OFolder("smalldata/./baddata.data");
    TestUtil.parseFromH2OFolder("smalldata/./categoricals/30k_categoricals.csv.gz");
    TestUtil.parseFromH2OFolder("smalldata/./categoricals/40k_categoricals.csv.gz");
    TestUtil.parseFromH2OFolder("smalldata/./categoricals/AllBedrooms_Rent_Neighborhoods.csv.gz");
    TestUtil.parseFromH2OFolder("smalldata/./categoricals/apartments_rec.csv");
    TestUtil.parseFromH2OFolder("smalldata/./categoricals/TwoBedrooms_Rent_Neighborhoods.csv.gz");
    TestUtil.parseFromH2OFolder("smalldata/./cebexpanded.csv");
    TestUtil.parseFromH2OFolder("smalldata/./cebexpandedREADME.rtf");
    TestUtil.parseFromH2OFolder("smalldata/./chess/chess_1x2x1000/h2o/test.csv");
    TestUtil.parseFromH2OFolder("smalldata/./chess/chess_1x2x1000/h2o/train.csv");
    TestUtil.parseFromH2OFolder("smalldata/./chess/chess_2x1x1000/h2o/test.csv");
    TestUtil.parseFromH2OFolder("smalldata/./chess/chess_2x1x1000/h2o/train.csv");
    TestUtil.parseFromH2OFolder("smalldata/./chess/chess_2x2x10/h2o/test.csv");
    TestUtil.parseFromH2OFolder("smalldata/./chess/chess_2x2x10/h2o/train.csv");
    TestUtil.parseFromH2OFolder("smalldata/./chess/chess_2x2x10/R/test.csv");
    TestUtil.parseFromH2OFolder("smalldata/./chess/chess_2x2x10/R/train.csv");
    TestUtil.parseFromH2OFolder("smalldata/./chess/chess_2x2x10/rf.conf");
    TestUtil.parseFromH2OFolder("smalldata/./chess/chess_2x2x10/weka/test.csv.arff");
    TestUtil.parseFromH2OFolder("smalldata/./chess/chess_2x2x10/weka/train.csv.arff");
    TestUtil.parseFromH2OFolder("smalldata/./chess/chess_2x2x100/h2o/test.csv");
    TestUtil.parseFromH2OFolder("smalldata/./chess/chess_2x2x100/h2o/train.csv");
    TestUtil.parseFromH2OFolder("smalldata/./chess/chess_2x2x100/R/test.csv");
    TestUtil.parseFromH2OFolder("smalldata/./chess/chess_2x2x100/R/train.csv");
    TestUtil.parseFromH2OFolder("smalldata/./chess/chess_2x2x100/rf.conf");
    TestUtil.parseFromH2OFolder("smalldata/./chess/chess_2x2x100/weka/test.csv.arff");
    TestUtil.parseFromH2OFolder("smalldata/./chess/chess_2x2x100/weka/train.csv.arff");
    TestUtil.parseFromH2OFolder("smalldata/./chess/chess_2x2x1000/h2o/test.csv");
    TestUtil.parseFromH2OFolder("smalldata/./chess/chess_2x2x1000/h2o/train.csv");
    TestUtil.parseFromH2OFolder("smalldata/./chess/chess_2x2x1000/R/test.csv");
    TestUtil.parseFromH2OFolder("smalldata/./chess/chess_2x2x1000/R/train.csv");
    TestUtil.parseFromH2OFolder("smalldata/./chess/chess_2x2x1000/rf.conf");
    TestUtil.parseFromH2OFolder("smalldata/./chess/chess_2x2x1000/weka/test.csv.arff");
    TestUtil.parseFromH2OFolder("smalldata/./chess/chess_2x2x1000/weka/train.csv.arff");
    TestUtil.parseFromH2OFolder("smalldata/./chess/chess_2x2x200/h2o/test.csv");
    TestUtil.parseFromH2OFolder("smalldata/./chess/chess_2x2x200/h2o/train.csv");
    TestUtil.parseFromH2OFolder("smalldata/./chess/chess_2x2x200/R/test.csv");
    TestUtil.parseFromH2OFolder("smalldata/./chess/chess_2x2x200/R/train.csv");
    TestUtil.parseFromH2OFolder("smalldata/./chess/chess_2x2x200/rf.conf");
    TestUtil.parseFromH2OFolder("smalldata/./chess/chess_2x2x200/weka/test.csv.arff");
    TestUtil.parseFromH2OFolder("smalldata/./chess/chess_2x2x200/weka/train.csv.arff");
    TestUtil.parseFromH2OFolder("smalldata/./chess/chess_2x2x500/h2o/chess_2x2_500_int.csv");
    TestUtil.parseFromH2OFolder("smalldata/./chess/chess_2x2x500/h2o/test.csv");
    TestUtil.parseFromH2OFolder("smalldata/./chess/chess_2x2x500/h2o/train.csv");
    TestUtil.parseFromH2OFolder("smalldata/./chess/chess_2x2x500/R/test.csv");
    TestUtil.parseFromH2OFolder("smalldata/./chess/chess_2x2x500/R/train.csv");
    TestUtil.parseFromH2OFolder("smalldata/./chess/chess_2x2x500/rf.conf");
    TestUtil.parseFromH2OFolder("smalldata/./chess/chess_2x2x500/weka/test.csv.arff");
    TestUtil.parseFromH2OFolder("smalldata/./chess/chess_2x2x500/weka/train.csv.arff");
    TestUtil.parseFromH2OFolder("smalldata/./constantColumn.csv");
    TestUtil.parseFromH2OFolder("smalldata/./cuse.data.csv");
    TestUtil.parseFromH2OFolder("smalldata/./cusedataREADME.rtf");
    TestUtil.parseFromH2OFolder("smalldata/./cuseexpanded.csv");
    TestUtil.parseFromH2OFolder("smalldata/./datagen1.csv");
    TestUtil.parseFromH2OFolder("smalldata/./datetime/dd-mon-yr.csv");
    TestUtil.parseFromH2OFolder("smalldata/./datetime/dd-mon-yy-with-other-cols.csv");
    TestUtil.parseFromH2OFolder("smalldata/./drugs.csv");
    TestUtil.parseFromH2OFolder("smalldata/./dummydata.csv");
    TestUtil.parseFromH2OFolder("smalldata/./fail1_100x11000.csv.gz");
    TestUtil.parseFromH2OFolder("smalldata/./fail2_24_100000_10.csv.gz");
    TestUtil.parseFromH2OFolder("smalldata/./fish.csv");
    TestUtil.parseFromH2OFolder("smalldata/./gaussian/sdss174052.csv.gz");
    TestUtil.parseFromH2OFolder("smalldata/./gbm_test/ecology_eval.csv");
    TestUtil.parseFromH2OFolder("smalldata/./gbm_test/ecology_model.csv");
    TestUtil.parseFromH2OFolder("smalldata/./glm_test/poisson_tst1.csv");
    TestUtil.parseFromH2OFolder("smalldata/./glm_test/prostate_cat_replaced.csv");
    TestUtil.parseFromH2OFolder("smalldata/./gt69436csv.data");
    TestUtil.parseFromH2OFolder("smalldata/./hex-443.parsetmp_1_0_0_0.data");
    TestUtil.parseFromH2OFolder("smalldata/./hhp.cut3.214.data.gz");
    TestUtil.parseFromH2OFolder("smalldata/./hhp_107_01.data.gz");
    TestUtil.parseFromH2OFolder("smalldata/./hhp_9_17_12.predict.data.gz");
    TestUtil.parseFromH2OFolder("smalldata/./iris/iris.csv.gz");
    TestUtil.parseFromH2OFolder("smalldata/./iris/iris.csv.zip");
    TestUtil.parseFromH2OFolder("smalldata/./iris/iris.xls");
    TestUtil.parseFromH2OFolder("smalldata/./iris/iris.xlsx");
    TestUtil.parseFromH2OFolder("smalldata/./iris/iris2.csv");
    TestUtil.parseFromH2OFolder("smalldata/./iris/iris22.csv");
//    TestUtil.parseFromH2OFolder("smalldata/./iris/iris_header.csv");
    TestUtil.parseFromH2OFolder("smalldata/./iris/iris_test.csv");
    TestUtil.parseFromH2OFolder("smalldata/./iris/iris_train.csv");
    TestUtil.parseFromH2OFolder("smalldata/./iris/iris_wheader.csv");
    TestUtil.parseFromH2OFolder("smalldata/./iris/iris_wheader.csv.gz");
    TestUtil.parseFromH2OFolder("smalldata/./iris/iris_wheader.csv.zip");
    TestUtil.parseFromH2OFolder("smalldata/./iris/leads.csv");
    TestUtil.parseFromH2OFolder("smalldata/./kaggle/bestbuy_train_10k.csv.gz");
    TestUtil.parseFromH2OFolder("smalldata/./kaggle/creditsample-test.csv.gz");
    TestUtil.parseFromH2OFolder("smalldata/./kaggle/creditsample-training.csv.gz");
    TestUtil.parseFromH2OFolder("smalldata/./kaggle/KDDTest.arff.gz");
    TestUtil.parseFromH2OFolder("smalldata/./kaggle/KDDTrain.arff.gz");
    TestUtil.parseFromH2OFolder("smalldata/./linreg/data.gz");
    TestUtil.parseFromH2OFolder("smalldata/./logreg/100kx7_logreg.data.gz");
    TestUtil.parseFromH2OFolder("smalldata/./logreg/benign.csv");
    TestUtil.parseFromH2OFolder("smalldata/./logreg/benign.xls");
    TestUtil.parseFromH2OFolder("smalldata/./logreg/failtoconverge_1000x501.csv.gz");
    TestUtil.parseFromH2OFolder("smalldata/./logreg/failtoconverge_100x50.csv");
    TestUtil.parseFromH2OFolder("smalldata/./logreg/logreg_trisum_int_cat_10000x10.csv");
    TestUtil.parseFromH2OFolder("smalldata/./logreg/make_me_converge_10000x5.csv");
    TestUtil.parseFromH2OFolder("smalldata/./logreg/princeton/copen.dat");
    TestUtil.parseFromH2OFolder("smalldata/./logreg/princeton/cuse.dat");
    TestUtil.parseFromH2OFolder("smalldata/./logreg/princeton/housing.raw");
    TestUtil.parseFromH2OFolder("smalldata/./logreg/pros.xls");
    TestUtil.parseFromH2OFolder("smalldata/./logreg/prostate_test.csv");
    TestUtil.parseFromH2OFolder("smalldata/./logreg/prostate_train.csv");
    TestUtil.parseFromH2OFolder("smalldata/./logreg/syn_2659x1049.csv");
    TestUtil.parseFromH2OFolder("smalldata/./logreg/syn_2659x1049x2enum.csv");
    TestUtil.parseFromH2OFolder("smalldata/./logreg/syn_8686576441534898792_10000x100.csv");
    TestUtil.parseFromH2OFolder("smalldata/./logreg/umass_chdage.csv");
    TestUtil.parseFromH2OFolder("smalldata/./logreg/umass_statdata/cgd.dat");
    TestUtil.parseFromH2OFolder("smalldata/./logreg/umass_statdata/chdage.dat");
    TestUtil.parseFromH2OFolder("smalldata/./logreg/umass_statdata/chdage_cleaned.dat");
    TestUtil.parseFromH2OFolder("smalldata/./logreg/umass_statdata/clslowbwt.dat");
    TestUtil.parseFromH2OFolder("smalldata/./logreg/umass_statdata/icu.dat");
    TestUtil.parseFromH2OFolder("smalldata/./logreg/umass_statdata/lowbwt.dat");
    TestUtil.parseFromH2OFolder("smalldata/./logreg/umass_statdata/lowbwtm11.dat");
    TestUtil.parseFromH2OFolder("smalldata/./logreg/umass_statdata/meexp.dat");
    TestUtil.parseFromH2OFolder("smalldata/./logreg/umass_statdata/nhanes3.dat");
    TestUtil.parseFromH2OFolder("smalldata/./logreg/umass_statdata/pbc.dat");
    TestUtil.parseFromH2OFolder("smalldata/./logreg/umass_statdata/pharynx.dat");
    TestUtil.parseFromH2OFolder("smalldata/./logreg/umass_statdata/pros.dat");
    TestUtil.parseFromH2OFolder("smalldata/./logreg/umass_statdata/uis.dat");
    TestUtil.parseFromH2OFolder("smalldata/./logreg/why_perfect_training_100x500.csv");
    TestUtil.parseFromH2OFolder("smalldata/./mixed_causes_NA.csv");
    TestUtil.parseFromH2OFolder("smalldata/./mtcars.csv");
    TestUtil.parseFromH2OFolder("smalldata/./neural/Benchmark_dojo_test.data");
    TestUtil.parseFromH2OFolder("smalldata/./neural/eightsq.data");
    TestUtil.parseFromH2OFolder("smalldata/./neural/sin_pattern.data");
    TestUtil.parseFromH2OFolder("smalldata/./neural/sumsigmoids.csv");
    TestUtil.parseFromH2OFolder("smalldata/./neural/sumsigmoids_test.csv");
    TestUtil.parseFromH2OFolder("smalldata/./neural/two_spiral.data");
    TestUtil.parseFromH2OFolder("smalldata/./parity_128_4_100_quad.data");
    TestUtil.parseFromH2OFolder("smalldata/./parity_128_4_2_quad.data");
    TestUtil.parseFromH2OFolder("smalldata/./parse_fail_double_space.csv");
    TestUtil.parseFromH2OFolder("smalldata/./parse_folder_test/prostate_0.csv");
    TestUtil.parseFromH2OFolder("smalldata/./parse_folder_test/prostate_1.csv");
    TestUtil.parseFromH2OFolder("smalldata/./parse_folder_test/prostate_2.csv");
    TestUtil.parseFromH2OFolder("smalldata/./parse_folder_test/prostate_3.csv");
    TestUtil.parseFromH2OFolder("smalldata/./parse_folder_test/prostate_4.csv");
    TestUtil.parseFromH2OFolder("smalldata/./parse_folder_test/prostate_5.csv");
    TestUtil.parseFromH2OFolder("smalldata/./parse_folder_test/prostate_6.csv");
    TestUtil.parseFromH2OFolder("smalldata/./parse_folder_test/prostate_7.csv");
    TestUtil.parseFromH2OFolder("smalldata/./parse_folder_test/prostate_8.csv");
    TestUtil.parseFromH2OFolder("smalldata/./parse_folder_test/prostate_9.csv");
    TestUtil.parseFromH2OFolder("smalldata/./parse_zeros_100x8500.csv.gz");
    TestUtil.parseFromH2OFolder("smalldata/./pca_test/AustraliaCoast.csv");
    TestUtil.parseFromH2OFolder("smalldata/./pca_test/USArrests.csv");
    TestUtil.parseFromH2OFolder("smalldata/./pmml/cars-cater-rf-1tree.pmml");
    TestUtil.parseFromH2OFolder("smalldata/./pmml/cars-cater-rf-50trees.pmml");
    TestUtil.parseFromH2OFolder("smalldata/./pmml/cars-rf-1tree.pmml");
    TestUtil.parseFromH2OFolder("smalldata/./pmml/cars-rf-50trees.pmml");
    TestUtil.parseFromH2OFolder("smalldata/./pmml/copen-rf-1tree.pmml");
    TestUtil.parseFromH2OFolder("smalldata/./pmml/copen-rf-50trees.pmml");
    TestUtil.parseFromH2OFolder("smalldata/./pmml/iris_rf_1tree.pmml");
    TestUtil.parseFromH2OFolder("smalldata/./pmml/iris_rf_500trees.pmml");
    TestUtil.parseFromH2OFolder("smalldata/./pmml/SampleScorecard.pmml");
    TestUtil.parseFromH2OFolder("smalldata/./poisson/Goalies.csv");
    TestUtil.parseFromH2OFolder("smalldata/./poker/poker-hand-testing.data");
    TestUtil.parseFromH2OFolder("smalldata/./poker/poker-hand.pl");
    TestUtil.parseFromH2OFolder("smalldata/./poker/poker10");
    TestUtil.parseFromH2OFolder("smalldata/./poker/poker100");
    TestUtil.parseFromH2OFolder("smalldata/./poker/poker1000");
    TestUtil.parseFromH2OFolder("smalldata/./random1csv.data");
    TestUtil.parseFromH2OFolder("smalldata/./randomdata2.csv");
    TestUtil.parseFromH2OFolder("smalldata/./randomdata3.csv");
    TestUtil.parseFromH2OFolder("smalldata/./smtrees.csv");
    TestUtil.parseFromH2OFolder("smalldata/./space_shuttle_damage.csv");
    TestUtil.parseFromH2OFolder("smalldata/./stego/stego_testing.data");
    TestUtil.parseFromH2OFolder("smalldata/./stego/stego_training.data");
    TestUtil.parseFromH2OFolder("smalldata/./stego/stego_training_modified.data");
    TestUtil.parseFromH2OFolder("smalldata/./swiss.csv");
    TestUtil.parseFromH2OFolder("smalldata/./syn_binary10Kx100.csv.gz");
    TestUtil.parseFromH2OFolder("smalldata/./syn_fp_prostate.csv");
    TestUtil.parseFromH2OFolder("smalldata/./syn_sphere2.csv");
    TestUtil.parseFromH2OFolder("smalldata/./syn_sphere3.csv");
    TestUtil.parseFromH2OFolder("smalldata/./test/arit.csv");
    TestUtil.parseFromH2OFolder("smalldata/./test/classifier/chess_test.csv");
    TestUtil.parseFromH2OFolder("smalldata/./test/classifier/chess_train.csv");
    TestUtil.parseFromH2OFolder("smalldata/./test/classifier/coldom_test_1.csv");
    TestUtil.parseFromH2OFolder("smalldata/./test/classifier/coldom_test_1_2.csv");
    TestUtil.parseFromH2OFolder("smalldata/./test/classifier/coldom_test_2.csv");
    TestUtil.parseFromH2OFolder("smalldata/./test/classifier/coldom_test_3.csv");
    TestUtil.parseFromH2OFolder("smalldata/./test/classifier/coldom_train_1.csv");
    TestUtil.parseFromH2OFolder("smalldata/./test/classifier/coldom_train_2.csv");
    TestUtil.parseFromH2OFolder("smalldata/./test/classifier/coldom_train_3.csv");
    TestUtil.parseFromH2OFolder("smalldata/./test/classifier/iris_missing_values.csv");
    TestUtil.parseFromH2OFolder("smalldata/./test/classifier/iris_test.csv");
    TestUtil.parseFromH2OFolder("smalldata/./test/classifier/iris_test_extra.csv");
    TestUtil.parseFromH2OFolder("smalldata/./test/classifier/iris_test_extra_with_na.csv");
    TestUtil.parseFromH2OFolder("smalldata/./test/classifier/iris_test_missing.csv");
    TestUtil.parseFromH2OFolder("smalldata/./test/classifier/iris_test_missing_extra.csv");
    TestUtil.parseFromH2OFolder("smalldata/./test/classifier/iris_test_numeric.csv");
    TestUtil.parseFromH2OFolder("smalldata/./test/classifier/iris_test_numeric_extra.csv");
    TestUtil.parseFromH2OFolder("smalldata/./test/classifier/iris_test_numeric_extra2.csv");
    TestUtil.parseFromH2OFolder("smalldata/./test/classifier/iris_test_numeric_missing.csv");
    TestUtil.parseFromH2OFolder("smalldata/./test/classifier/iris_test_numeric_missing_extra.csv");
    TestUtil.parseFromH2OFolder("smalldata/./test/classifier/iris_train.csv");
    TestUtil.parseFromH2OFolder("smalldata/./test/classifier/iris_train_numeric.csv");
    TestUtil.parseFromH2OFolder("smalldata/./test/HEX-287-small-files.data");
    TestUtil.parseFromH2OFolder("smalldata/./test/HTWO-87-one-line-dataset-0.csv");
    TestUtil.parseFromH2OFolder("smalldata/./test/HTWO-87-one-line-dataset-1dos.csv");
    TestUtil.parseFromH2OFolder("smalldata/./test/HTWO-87-one-line-dataset-1unix.csv");
    TestUtil.parseFromH2OFolder("smalldata/./test/HTWO-87-one-line-dataset-2dos.csv");
    TestUtil.parseFromH2OFolder("smalldata/./test/HTWO-87-one-line-dataset-2unix.csv");
    TestUtil.parseFromH2OFolder("smalldata/./test/HTWO-87-two-lines-dataset.csv");
    TestUtil.parseFromH2OFolder("smalldata/./test/HTWO-87-two-unique-lines-dataset.csv");
    TestUtil.parseFromH2OFolder("smalldata/./test/is_NA.csv");
    TestUtil.parseFromH2OFolder("smalldata/./test/na_test.zip");
//    TestUtil.parseFromH2OFolder("smalldata/./test/rmodels/covtype-rf-50tree-as-factor-X5-20k.rdata");
//    TestUtil.parseFromH2OFolder("smalldata/./test/rmodels/covtype-rf-50tree-as-factor-X5.rdata");
    TestUtil.parseFromH2OFolder("smalldata/./test/rmodels/covtype.rf.2");
//    TestUtil.parseFromH2OFolder("smalldata/./test/rmodels/iris_x-iris-1-4_y-species_ntree-3.rdata");
//    TestUtil.parseFromH2OFolder("smalldata/./test/rmodels/iris_x-iris-1-4_y-species_ntree-500.rdata");
//    TestUtil.parseFromH2OFolder("smalldata/./test/rmodels/ozone.rf.10trees.rdata");
//    TestUtil.parseFromH2OFolder("smalldata/./test/rmodels/prostate-rf-10tree-asFactorCapsule.rdata");
//    TestUtil.parseFromH2OFolder("smalldata/./test/rmodels/prostate-rf-1tree-asFactorCapsule.rdata");
//    TestUtil.parseFromH2OFolder("smalldata/./test/rmodels/prostate-rf-2tree-asFactorCapsule.rdata");
    TestUtil.parseFromH2OFolder("smalldata/./test/rmodels/rf-iris-1tree.model");
    TestUtil.parseFromH2OFolder("smalldata/./test/test1.dat");
    TestUtil.parseFromH2OFolder("smalldata/./test/test_26cols_comma_sep.csv");
    TestUtil.parseFromH2OFolder("smalldata/./test/test_26cols_multi_space_sep.csv");
    TestUtil.parseFromH2OFolder("smalldata/./test/test_26cols_single_space_sep.csv");
    TestUtil.parseFromH2OFolder("smalldata/./test/test_26cols_single_space_sep_2.csv");
    TestUtil.parseFromH2OFolder("smalldata/./test/test_all_raw_top10rows.csv");
    TestUtil.parseFromH2OFolder("smalldata/./test/test_enum_domain_size.csv");
    TestUtil.parseFromH2OFolder("smalldata/./test/test_less_than_65535_unique_names.csv");
    TestUtil.parseFromH2OFolder("smalldata/./test/test_manycol_tree.csv");
    TestUtil.parseFromH2OFolder("smalldata/./test/test_more_than_65535_unique_names.csv");
    TestUtil.parseFromH2OFolder("smalldata/./test/test_percentiles_distns.csv.gz");
    TestUtil.parseFromH2OFolder("smalldata/./test/test_percentiles_distns.R");
    TestUtil.parseFromH2OFolder("smalldata/./test/test_quote.csv");
    TestUtil.parseFromH2OFolder("smalldata/./test/test_tree.csv");
    TestUtil.parseFromH2OFolder("smalldata/./test/test_tree_minmax.csv");
    TestUtil.parseFromH2OFolder("smalldata/./test/test_var.csv");
    TestUtil.parseFromH2OFolder("smalldata/./Test_Arabic_Digit_short.data");
    TestUtil.parseFromH2OFolder("smalldata/./tnc3.csv");
    TestUtil.parseFromH2OFolder("smalldata/./tnc3_10.csv");
    TestUtil.parseFromH2OFolder("smalldata/./tnc6.csv");
    TestUtil.parseFromH2OFolder("smalldata/./toykm.csv");
    TestUtil.parseFromH2OFolder("smalldata/./trees.csv");
    TestUtil.parseFromH2OFolder("smalldata/./unbalanced/orange_small_test.data.zip");
    TestUtil.parseFromH2OFolder("smalldata/./unbalanced/orange_small_train.data.zip");
    TestUtil.parseFromH2OFolder("smalldata/./wine.data");
    TestUtil.parseFromH2OFolder("smalldata/./winesPCA.csv");
    TestUtil.parseFromH2OFolder("smalldata/./wonkysummary.csv");
    TestUtil.parseFromH2OFolder("smalldata/./zero_dot_zero_one.csv");
    TestUtil.parseFromH2OFolder("smalldata/./zero_dot_zero_zero_one.csv");
    TestUtil.parseFromH2OFolder("smalldata/./zinb.csv");
    TestUtil.parseFromH2OFolder("smalldata/./zip_code/zip_code_database.csv.gz");
    TestUtil.parseFromH2OFolder("smalldata/./zipcodes");
    reBalanceFrames();
    testTrainSplitFrames();
  }

  @Override protected void execImpl() {
    load();
  }

  public void reBalanceFrames () {
    final Key [] keySet = H2O.KeySnapshot.globalSnapshot().keys();
    for (Key key : keySet) {
      final Value val = DKV.get(key);
      if (val == null || !val.isFrame()) continue;
      final Frame fr = val.get();
      if (!fr._key.toString().contains("balanced")) {
        final int splits = Math.min((int)fr.numRows(), 4*H2O.NUMCPUS*H2O.CLOUD.size());
        final String name = fr._key.toString() + ".rebalanced";
        Log.info("Load balancing frame under key '" + fr._key.toString() + "' into " + splits + " splits.");
        try {
          final Key frHexBalanced = Key.make(name);
          new RebalanceDataSet(fr, frHexBalanced, splits).invoke();
        } catch(Exception ex) {
          Log.err(ex.getMessage());
        }
      }
    }
  }

  public void testTrainSplitFrames () {
    final Key []  keySet = H2O.KeySnapshot.globalSnapshot().keys();
    for (Key key : keySet) {
      final Value val = DKV.get(key);
      if (val == null || !val.isFrame()) continue;
      final Frame fr = val.get();
      if (!fr._key.toString().contains("_part")) {
        Log.info("Splitting frame under key '" + fr._key.toString() + "' into 75%/25% train/test splits.");
        try {
          FrameSplitPage fsp = new FrameSplitPage();
          fsp.source = fr;
          fsp.ratios = new float[]{0.75f};
          fsp.split_keys = null;
          fsp.split_rows = null;
          fsp.split_ratios = null;
          fsp.invoke();
        } catch(Exception ex) {
          Log.err(ex.getMessage());
        }
      }
    }
  }
}
