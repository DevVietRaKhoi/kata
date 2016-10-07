<?php

// Remember to read: http://php.net/manual/en/features.commandline.io-streams.php

// Obtain handle to STDIN for reading
$stdin = fopen('php://stdin', 'r');

// Obtain handle to STDOUT for writing
$stdout = fopen('php://stdout', 'w');

// You can use STDOUT or $stdout
fprintf(STDOUT, "Input M & N: ");
// You can use STDIN or $stdin. Does anyone remember scanning?
fscanf($stdin, "%d %d\n", $M, $N);
// An example with $stdout
fprintf($stdout, "(M, N) = (%d, %d)\n", $M, $N);

// Tell me something smart
fprintf(STDOUT, "Your favorite quote:\n");
// Get whole line and trim it, trust no user
$line = strrev(trim(fgets(STDIN)));
fprintf(STDOUT, "Reversed: %s\n", $line);
