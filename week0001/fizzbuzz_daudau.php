<?php
	$i = 0;
	while ($i++ < 100) {
		if ($i % 3 == 0)
			fwrite(STDOUT, "Fizz".PHP_EOL);
		if ($i % 5 == 0)
			fwrite(STDOUT, "Buzz".PHP_EOL);
	}