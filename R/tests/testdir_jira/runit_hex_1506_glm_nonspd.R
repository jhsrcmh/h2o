######################################################################
# Test for HEX-1506
# h2o.glm() should return warning if matrix is non-SPD
######################################################################

# setwd("/Users/tomk/0xdata/ws/h2o/R/tests/testdir_jira")

setwd(normalizePath(dirname(R.utils::commandArgs(asValues=TRUE)$"f")))
options(echo=TRUE)
source('../findNSourceUtils.R')

heading("BEGIN TEST")
conn <- new("H2OClient", ip=myIP, port=myPort)

path = locate("smalldata/iris/iris_wheader.nonspd.csv")
iris.hex = h2o.uploadFile.VA(conn, path, key="iris.hex")

expect_warning(h2o.glm(x = c(1:4,6:8), y = "class", data = iris.hex, family = "binomial", lambda = 0, version = 1))
expect_warning(h2o.glm(x = c(1:4,6:8), y = "class", data = iris.hex, family = "binomial", lambda = c(0,1e-5,0.1), version = 1))

PASS_BANNER()
