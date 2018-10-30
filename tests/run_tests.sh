#!/bin/bash

for line in $(find . -iname 'input.txt'); do
	value=exec cat $line
	printf "$value" | exec java -cp ../bin/ QIESBase ../build/vsf.txt
done

