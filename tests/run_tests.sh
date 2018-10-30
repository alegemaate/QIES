#!/bin/bash

for line in $(find . -iname 'input.txt'); do
	# Lines from input
	value="$(cat $line)"
	

	# Directory 
	DIR=$(dirname "${line}")
	
	# Test header
	echo -e "===========================\n${DIR}\n===========================\n"
	
	# Run Test
	cd "../build/"
	echo -e "${value}\nexit" | java -cp ../bin "QIESBase" "vsf.txt"
	
	# Copy txn summary
	cd "../tests/"
	cp "../build/transactions/txnsum.txt" "${DIR}/txnsum.txt"
	
	
	# Compare files
	echo -e "\n\nDIFF\n"
	diff "${DIR}/txnsum.txt" "${DIR}/output_file.txt"
	rm "${DIR}/txnsum.txt"
	echo -e "\n\n\n"
done

