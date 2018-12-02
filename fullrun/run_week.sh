#!/bin/bash

#
# WEEKLY RUN SCRIPT
# CISC327 GROUP 13     
# SPICE TESTS
# 02/12/2018
#
# to run: 
#   You must have java installed on your linux system
#     run java -h to check if it is installed
#
#   QIES can be built, or you can use the provided .class files.
#     To build QUIES:
#			navigate to ./backoffice/src/ directory and execute:
#     	javac BackOffice.java -d ../bin/
#			navigate to ./frontend/src/ directory and execute:
#				javac FrontEnd.java -d ../bin/
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

# Remove old csf and vsf
rm "./csf.txt" 2> /dev/null
rm "./vsf.txt" 2> /dev/null

# Create empty csf and vsf
touch "./csf.txt"
touch "./vsf.txt"

# 5 days in a QIES week
for i in 1 2 3 4 5; do
	bash ./run_day.sh $i
done

# Output
echo -e "\e[104mWEEK COMPLETE!\e[0m\n"