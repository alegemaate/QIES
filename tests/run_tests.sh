#!/bin/bash

# Counters
fails=0
successes=0
tests_run=0

for line in $(find . -iname 'input.txt'); do
	# Lines from input
	value="$(cat $line)"

	# Directory 
	DIR=$(dirname "${line}")
	
	# Test header
	echo -e "\e[93m===========================\n${DIR}\n===========================\e[0m"
	
	# Clear last test
	rm "${DIR}/txnsum_actual.txt" 2> /dev/null
	rm "${DIR}/console.log" 2> /dev/null
	rm "${DIR}/diff.log" 2> /dev/null
	rm "../build/transactions/txnsum.txt" 2> /dev/null
	
	# Run Test
	cp "${DIR}/vsf.txt" "../build/vsf.txt"
	cd "../build/"
	run_output=$(echo -e "${value}\nexit" | java -cp ../bin "QIESBase" "vsf.txt")
	
	# Copy txn summary
	cd "../tests/"
	cp "../build/transactions/txnsum.txt" "${DIR}/txnsum_actual.txt"
	
	
	# Compare files
	diff_output=""
	if cmp -s "${DIR}/txnsum_actual.txt" "${DIR}/txnsum_expected.txt"
	then
		echo -e "\e[32mSUCCESS\e[0m\n"
		successes=$((successes+1))
	else
		echo -e "\e[31mFAILURE\e[0m\n"
		echo -e "log\n--------"
		echo -e "$run_output"
		echo -e "\ndiff\n--------"
		diff_output=$(diff -y "${DIR}/txnsum_actual.txt" "${DIR}/txnsum_expected.txt")
		echo -e "$diff_output"
		fails=$((fails+1))
	fi
	
	# Write to logs
	echo -e "$run_output" > "${DIR}/console.log"
	echo -e "$diff_output" > "${DIR}/diff.log"
	
	
	# Formatting
	echo -e "\n"
	
	# Increment total runs
	tests_run=$((tests_run+1))
done

# Output
echo -e "\e[104mTESTS COMPLETE:\e[0m\n  \e[31mFails:${fails}\n  \e[32mSuccesses:${successes}\n  \e[0mTests Run:${tests_run}\n"

