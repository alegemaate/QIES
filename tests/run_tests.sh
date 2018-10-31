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
	
	# Clear last test
	rm "${DIR}/txnsum_actual.txt"
	
	# Run Test
	cp "${DIR}/vsf.txt" "../build/vsf.txt"
	cd "../build/"
	echo -e "${value}\nexit" | java -cp ../bin "QIESBase" "vsf.txt"
	
	# Copy txn summary
	cd "../tests/"
	cp "../build/transactions/txnsum.txt" "${DIR}/txnsum_actual.txt"
	
	# Compare files
	if cmp -s "${DIR}/txnsum_actual.txt" "${DIR}/txnsum_expected.txt"
	then
		echo "SUCCESS"
		successes=$((successes+1))
	else
		echo "FAILED"
		diff "${DIR}/txnsum_actual.txt" "${DIR}/txnsum_expected.txt"
		fails=$((fails+1))
	fi
	
	echo -e "\n\n"
	
	tests_run=$((tests_run+1))
done

# Output
echo -e "TESTS COMPLETE:\n Fails:${fails}\n Successes:${successes}\n Tests Run:${tests_run}\n"

