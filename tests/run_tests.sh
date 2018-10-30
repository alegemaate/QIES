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
	echo -e "===========================\n${DIR}\n===========================\n"
	
	# Run Test
	cp "${DIR}/input_file.txt" "../build/vsf.txt"
	cd "../build/"
	echo -e "${value}\nexit" | java -cp ../bin "QIESBase" "vsf.txt"
	
	# Copy txn summary
	cd "../tests/"
	cp "../build/transactions/txnsum.txt" "${DIR}/txnsum.txt"
	
	# Compare files
	if cmp -s "${DIR}/txnsum.txt" "${DIR}/output_file.txt"
	then
		echo "SUCCESS"
		successes=$((successes+1))
	else
		echo "FAILED"
		diff "${DIR}/txnsum.txt" "${DIR}/output_file.txt"
		fails=$((fails+1))
	fi

	rm "${DIR}/txnsum.txt"
	echo -e "\n\n"
	
	tests_run=$((tests_run+1))
done

# Output
echo -e "TESTS COMPLETE:\n Fails:${fails}\n Successes:${successes}\n Tests Run:${tests_run}\n"

