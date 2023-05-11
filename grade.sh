CPATH='.;lib/hamcrest-core-1.3.jar;lib/junit-4.13.2.jar'

rm -rf student-submission
rm -rf grading-area

mkdir grading-area

git clone $1 student-submission
echo 'Finished cloning'

if [[ ! -f student-submission/ListExamples.java ]] 
then 
    echo "not correct file"
    exit
fi 

filedir=`find -name "ListExamples.java"`
cp -r $filedir grading-area/
cp -r TestListExamples.java grading-area/
cp -r lib grading-area/

cd grading-area
javac -cp $CPATH TestListExamples.java ListExamples.java 2> compile-error.txt
if [[ $? -ne 0 ]] 
then 
    echo "compile failed"
    exit
fi

java -cp $CPATH org.junit.runner.JUnitCore TestListExamples > test-output.txt
grep -oP '(?<=Failures: )\d+' test-output.txt

possibleScore=3
if [[ grep -q "Failures" test-output.txt ]]
then 
    result=$((possibleScore - $(echo grep -oP '(?<=Failures: )\d+' test-output.txt)))
    echo "Your score: $result/3"
fi
# Draw a picture/take notes on the directory structure that's set up after
# getting to this point

# Then, add here code to compile and run, and do any post-processing of the
# tests


