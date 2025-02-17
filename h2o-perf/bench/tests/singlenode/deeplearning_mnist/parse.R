source("../../../R/h2oPerf/prologue.R")

data_source <<- "home-0xdiag-datasets"

trainData    <<- "/home/0xdiag/datasets/mnist/mnist_training.csv.gz"
response <<- "C785"

num_train_rows  <<- 49749
num_explan_cols <<- 784

upload.FV("parsed.hex", trainData)

testData     <<- "/home/0xdiag/datasets/mnist/mnist_testing.csv.gz"
upload.FV("test.hex", testData)

source("../../../R/h2oPerf/epilogue.R")
