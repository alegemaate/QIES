#!/bin/bash

#
# DAILY RUN SCRIPT
# CISC327 GROUP 13     
# SPICE TESTS
# 02/12/2018
#
# See run_week.sh for instructions
#

# Ensure argument is given
if [ "$#" -ne "1" ]
  then echo You must provide 1 input. A day as a number.
	exit 1
fi

# Day argument
day=$1

# Remove old merged file
rm "./day${day}/mergedtsf.txt" 2> /dev/null

# 3 front ends
for i in 1 2 3; do
	# Session header
	echo -e "\e[93m===========================\nDay ${day}, Session ${i}\n===========================\e[0m"
	
	# Clear last txn summary and vsf
	rm "../frontend/build/vsf.txt" 2> /dev/null
	rm "../frontend/build/tsf.txt" 2> /dev/null
	
	# Lines from input file
	value="$(cat day${day}/input${i}.txt)"
	
	# Run dat
	cp "./vsf.txt" "../frontend/build/vsf.txt"
	cd "../frontend/build/"
	run_output=$(echo -e "${value}\nexit" | java -cp ../bin "FrontEnd" "vsf.txt")
	
	# Copy txn summary
	cd "../../fullrun/"
	cp "../frontend/build/tsf.txt" "./day${day}/tsf${i}.txt"

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
	# Remove last line if required
	if [ $i -ne 3 ]; then
		sed '$d' "./day${day}/tsf${i}.txt" >> "./day${day}/mergedtsf.txt"
	else
		cat "./day${day}/tsf${i}.txt" >> "./day${day}/mergedtsf.txt"
	fi
done

# Run backoffice
echo -e "\e[93m===========================\nDay ${day}, Back Office\n===========================\e[0m"

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
rm "./vsf.txt" 2> /dev/null

# Run backoffice
cd "../backoffice/build/"
run_output=$(java -cp ../bin "BackOffice" "csf.txt" "tsf.txt" "newcsf.txt" "vsf.txt")

# Copy over new vsf and csf
cd "../../fullrun/"
cp "../backoffice/build/vsf.txt" "./vsf.txt"
cp "../backoffice/build/newcsf.txt" "./csf.txt"

# Run console output
echo -e "console output\n--------"
echo -e "$run_output"

# Output
echo -e "\e[104mDAY ${day} COMPLETE!\e[0m\n"

# Print files to screen
echo -e "\e[95mVSF\e[0m"
cat "./vsf.txt"
echo -e "\n\e[95mCSF\e[0m"
cat "./csf.txt"
echo -e "\n"
