#!/bin/bash

# Counters
fails=0
successes=0
tests_run=0

# Clear past run
rm -rf output/*

# Parse inputs
for line in $(find . -iname 'input.txt'); do
	# Lines from input
	value="$(cat $line)"

	# Test Directory and Name
	TESTDIR=$(dirname "${line}")
	CATDIR=$(dirname "${TESTDIR}")
	testname=${TESTDIR##*/} 
	catname=${CATDIR##*/} 
	
	# Make Output Directory
	mkdir -p "./output/${catname}/"
	mkdir -p "./output/${catname}/${testname}/"
	
	# Test header
	echo -e "\e[93m===========================\n${testname}\n===========================\e[0m"
	
	# Clear last txn summary
	rm "../build/transactions/txnsum.txt" 2> /dev/null
	
	# Run Test
	cp "./input/${catname}/${testname}/vsf.txt" "../build/vsf.txt"
	cd "../build/"
	run_output=$(echo -e "${value}\nexit" | java -cp ../bin "QIESBase" "vsf.txt")
	
	# Copy txn summary
	cd "../tests/"
	cp "../build/transactions/txnsum.txt" "./output/${catname}/${testname}/txnsum.txt"
	
	# Compare files
	diff_output=""
	if cmp -s "expected/${catname}/${testname}/txnsum.txt" "output/${catname}/${testname}/txnsum.txt"; then
		echo -e "\e[32mSUCCESS\e[0m\n"
		successes=$((successes+1))
	else
		echo -e "\e[31mFAILURE\e[0m\n"
		echo -e "log\n--------"
		echo -e "$run_output"
		echo -e "\ndiff\n--------"
		diff_output=$(diff -y "expected/${catname}/${testname}/txnsum.txt" "output/${catname}/${testname}/txnsum.txt")
		echo -e "$diff_output"
		fails=$((fails+1))
	fi
	
	# Write to logs
	echo -e "$run_output" > "output/${catname}/${testname}/console.log"
	echo -e "$diff_output" > "output/${catname}/${testname}/diff.log"
	
	
	# Formatting
	echo -e "\n"
	
	# Increment total runs
	tests_run=$((tests_run+1))
done

# Output
echo -e "\e[104mTESTS COMPLETE:\e[0m\n  \e[31mFails:${fails}\n  \e[32mSuccesses:${successes}\n  \e[0mTests Run:${tests_run}\n"

