# Test Task: IP Address Counter
Counting number of unique ip addresses in a given text file.
I've picked BitSet as a way of storing given addressess - it can store a lot of bits that represent 1 (mentioned in the file) and 0 (not mentioned in the file) addresses. Then it gives a stream of marked bits (only [1] that I've set) that can be counted.

I've tested the program on big files, so I really wanted to see the progress bar, so I ran it in a separate thread and printed the results. Initially there were too many results, so I made it so only every 1000 line would be printed. 8 billion lines would still be giving a pretty verbose output, but the progress will be visible.
Counting lines before starting turned out to be way too slow, so I didn't display percentage of processed lines.

I can still improve the program by allowing the user to cancel the process and display all of the counted lines.
