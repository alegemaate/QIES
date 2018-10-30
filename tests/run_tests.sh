#!/bin/bash

# Counters
successes=0
fails=0

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
	if ! cmp "${DIR}/txnsum.txt" "${DIR}/output_file.txt"~ >/dev/null 2>&1
	then
		echo "FAILED"
		diff "${DIR}/txnsum.txt" "${DIR}/output_file.txt"
	else
		echo "SUCCESS"
	fi

	rm "${DIR}/txnsum.txt"
	echo -e "\n\n"
done

