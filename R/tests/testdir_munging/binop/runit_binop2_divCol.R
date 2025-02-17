##
# Test: binop2 / opeartor
# Description: Check the '/' binop2 operator
# Variations: e1 / e2
#    e1 & e2 H2OParsedData
#    e1 Numeric & e2 H2OParsedData
#    e1 H2OParsedData & e2 Numeric
##

setwd(normalizePath(dirname(R.utils::commandArgs(asValues=TRUE)$"f")))
source('../../findNSourceUtils.R')

setupRandomSeed(767640980)
#setupRandomSeed(857122247)

doSelect<-
function() {
    d <- select()
    dd <- d[[1]]$ATTRS
    if(any(dd$TYPES != "enum")) return(d)
    Log.info("No numeric columns found in data, trying a different selection")
    doSelect()
}

dataSet <- doSelect()
dataName <- names(dataSet)
print(dataName)
print(dataSet)
q()


test.slice.div <- function(conn) {
  dataSet <- doSelect()
  dataName <- names(dataSet)
  print(dataName)
  dd <- dataSet[[1]]$ATTRS
  colnames <- dd$NAMES
  numCols  <- as.numeric(dd$NUMCOLS)
  numRows  <- as.numeric(dd$NUMROWS)
  colTypes <- dd$TYPES
  colRange <- dd$RANGE
  Log.info(paste("Importing ", dataName, " data..."))
  hex <- h2o.uploadFile(conn, locate(dataSet[[1]]$PATHS[1]), paste("r", gsub('-','_',dataName),".hex", sep = ""))
  anyEnum <- FALSE
  if(any(dd$TYPES == "enum")) anyEnum <- TRUE

  Log.info("Try /ing a scalar to a numeric column: 5 / hex[,col]")
  #col <- sample(colnames[colTypes != "enum"], 1)
  #col <- ifelse(is.na(suppressWarnings(as.numeric(col))), col, as.numeric(col) + 1)
  #col <- ifelse(is.na(suppressWarnings(as.numeric(col))), col, paste("C", sep = "", collapse = ""))
  df <- head(hex)
  col <- sample(colnames(df[!sapply(df, is.factor)]), 1)
  if (!(grepl("\\.", col))) {
    col <- gsub("\\.", " ", sample(colnames(df[!sapply(df, is.factor)]), 1)) 
  }
    print(which(col == colnames(df)))

  print(colnames(hex))
  print(col)

  print(col %in% colnames(hex))
  print(col %in% colnames(df))

  if (!(col %in% colnames(hex))) {
    col <- which(col == colnames(df))
  }
  Log.info(paste("Using column: ", col))
 
  sliced <- hex[,col]
  Log.info("Placing key \"sliced.hex\" into User Store")
  sliced <- h2o.assign(sliced, "sliced.hex")
  print(h2o.ls(conn))

  Log.info("/ing 5 to sliced.hex")
  slicedDivFive <- sliced / 5

  slicedDivFive <- h2o.assign(slicedDivFive, "slicedDivFive.hex")

  Log.info("Orignal sliced: ")
  print(head(as.data.frame(sliced)))

  Log.info("Sliced / 5: ")
  print(head(as.data.frame(slicedDivFive)))
  expect_that(as.data.frame(slicedDivFive), equals(as.data.frame(sliced) / 5))

  Log.info("Checking left and right: ")
  slicedDivFive <- sliced / 5

  fiveDivSliced <- 5 / sliced

  Log.info("sliced / 5: ")
  print(head(slicedDivFive))

  Log.info("5 / sliced: ")
  print(head(fiveDivSliced))

  Log.info("Checking the variation of H2OParsedData / H2OParsedData")
  hexDivHex <- fiveDivSliced / slicedDivFive

  Log.info("FiveDivSliced / slicedDivFive: ")
  print(head(hexDivHex))
  Log.info("head(as.data.frame(fiveDivSliced)/as.data.frame(slicedDivFive))")
  print(head(as.data.frame(fiveDivSliced)/as.data.frame(slicedDivFive)))
  A <- data.frame(na.omit(as.data.frame(hexDivHex)))
  B <- data.frame(na.omit(as.data.frame(fiveDivSliced)) / na.omit(as.data.frame(slicedDivFive) ) )
  C <- sum(A == B)
  expect_that(C, equals(nrow(A)))

  testEnd()
}

doTest("BINOP2 EXEC2 TEST: /", test.slice.div)

