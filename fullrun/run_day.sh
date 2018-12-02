#!/bin/bash

#
# DAILY RUN SCRIPT
# CISC327 GROUP 13     
# SPICE TESTS
# 02/12/2018
#
# to run: 
#   You must have java installed on your linux system
#     run java -h to check if it is installed
#
#   QIES can be built, or you can use the provided .class files.
#     To build QUIES navigate to ./src/ directory and execute:
#     javac BackOffice.java -d ../bin/
#			javac FrontEnd.java -d ../bin/
#
#	  To run QUIES backend navigate to ./build/ directory and execute:
#			java -cp ../bin "BackOffice" "csf.txt" "tsf.txt" "newcsf.txt" "vsf.txt"
#
#	  To run QUIES front end navigate to ./build/ directory and execute:
#			java -cp ../bin "FrontEnd" "vsf.txt"
#
#   Once java is installed, and QIES is built... 
#     you may simply run ./run_day.sh
#     and the day will automatically be run.
#

# Ensure argument is given
if [ "$#" -lt "1" ]
  then echo You must provide 1 input. A day as a number.
	exit 1
fi

# Day argument
day=$1

# Remove old merged file
rm "./day${day}/mergedtsf.txt" 2> /dev/null

# 3 front ends
for i in 1 2 3; do
	# Test header
	echo -e "\e[93m===========================\nDay ${day}, Session ${i}\n===========================\e[0m"
	
	# Clear last txn summary and vsf
	rm "../frontend/build/vsf.txt" 2> /dev/null
	rm "../frontend/build/transactions/tsf.txt" 2> /dev/null
	
	# Lines from input file
	value="$(cat day${day}/input${i})"
	
	# Run dat
	cp "./vsf.txt" "../frontend/build/vsf.txt"
	cd "../frontend/build/"
	run_output=$(echo -e "${value}\nexit" | java -cp ../bin "FrontEnd" "vsf.txt")
	
	# Copy txn summary
	cd "../../fullrun/"
	cp "../frontend/build/transactions/tsf.txt" "./day${day}/tsf${i}.txt"

	# Log console output
	echo -e "$run_output" > "./day${day}/console${i}.log"
  
	# Run console output
	echo -e "console output\n--------"
	echo -e "$run_output"
	
	# Formatting
	echo -e "\n"
done

# Merge files
touch "./day${day}/mergedtsf.txt"

# 3 front ends
for i in 1 2 3; do
	cat "./day${day}/tsf${i}.txt" >> "./day${day}/mergedtsf.txt"
	
	# Remove last line
	if [ i -ne 3 ]; then
		sed -i '$ d' "./day${day}/mergedtsf.txt"
	fi
done

# Run backoffice
# Remove old files
rm "../backoffice/build/csf.txt" 2> /dev/null
rm "../backoffice/build/newcsf.txt" 2> /dev/null
rm "../backoffice/build/tsf.txt" 2> /dev/null
rm "../backoffice/build/vsf.txt" 2> /dev/null

# Copy inputs
cp "./day${day}/mergedtsf.txt" "../backoffice/build/tsf.txt"
cp "./csf.txt" "../backoffice/build/csf.txt"

# Remove csf from root
rm "./csf.txt" 2> /dev/null

# Run backoffice
cd "../backoffice/build/"
run_output=$(java -cp ../bin "BackOffice" "csf.txt" "tsf.txt" "newcsf.txt" "vsf.txt")

# Copy over new vsf and csf
mv "../../fullrun/"
cp "../backoffice/build/vsf.txt" "./day${day}/vsf.txt"
cp "../backoffice/build/newcsf.txt" "./csf.txt"

# Output
echo -e "\e[104mDAY ${day} COMPLETE:\e[0m\n"

