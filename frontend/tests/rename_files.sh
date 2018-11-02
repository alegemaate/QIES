#!/bin/bash

# Counter
changed=0

# Ensure arguments exist
if [ $# -eq 2 ]; then
	for line in $(find . -iname $1); do
		DIR=$(dirname "${line}")
		mv "$line" "${DIR}/${2}"
		changed=$((changed+1))
	done
else
	echo "Arguments must be old file name and new file name"
fi

echo "${changed} files changed."