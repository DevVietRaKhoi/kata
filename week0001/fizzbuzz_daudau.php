<?php
	$i = 1;
	while ($i++ < 100)
		echo $i%15 ? $i%3 ? $i%5 ? '' : 'buzz'.'<br/>' : 'fizz'.'<br/>' : 'fizz'.'<br/>'.'buzz'.'<br/>';