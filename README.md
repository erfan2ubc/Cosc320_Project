# **Summary** 

We chose the topic of keyword replacement in a corpus and developed two algorithms to solve the problem. The first algorithm involved saving the keywords in a tree and comparing them with the text to replace the abbreviations with their proper phrase. The second algorithm involved using regular expressions and a string-matching algorithm to find the closest matches to an abbreviation. 

We followed the standard four-step process for the project. We formulated the problem as an algorithmic problem and designed two algorithms; algorithm A, which was the straightforward solution to the problem, and algorithm B, which was a more efficient solution. We proved the correctness of algorithm B and compared the time complexities of both algorithms using the asymptotic notation. We then implemented both algorithms and performed simulations to empirically compare their running times.

# **Comparison of Algorithm 1 and Algorithm 2**

### Problem Formulation

The first algorithm involves saving the keywords in a tree structure, where each node contains two parts: the abbreviation and its corresponding phrase/keyword. The tree is sorted alphabetically, and the algorithm compares each word in the text with the words in the tree to find any matches. If a match is found, the algorithm replaces the abbreviation with its corresponding phrase/keyword.

The second algorithm involves using regular expressions to search for patterns in the text, and a string-matching algorithm to find the closest matches to an abbreviation in a list. The list of abbreviations is preprocessed by sorting them in order of length, and an index of the corpus of tweets is created. The algorithm then searches through the index for each abbreviation in the list and uses the string-matching algorithm to find the closest match. If a match is found, the abbreviation is replaced with its corresponding phrase/keyword.

### Pseudo Code

|Algorithm 1|Algorithm 2|
| - | - |
|**class** **Node**<**T**> {<br>T abbreviations;<br>T expansion;<br>Node<T> next;<br>Node<T> tail;<br>Node(T abbreviations, T expansion) {<br>**this**.abbreviations = abbreviations;<br>**this**.expansion = expansion;<br>}<br>}<br>Class AbbTree {<br>Node root;<br>Node tail;<br>**int** maxBranchSize = n;<br>AbbTree(root) {<br>root.abbreviations = **null**;<br>root.expansion = **null**;<br>root.next = **null**;<br>}<br>Insert(String abbreviations, String expansion) {<br>If(branchSize < maxBranchSize) {<br>Node newNode = **new** Node(abbreviations,expansion);<br>tail.next = newNode;<br>tail = newNode;<br>}<br>Else {<br>Node newNode = **new** Node(abbreviations,expansion);<br>root.next = newNode;<br>tail = newNode;<br>}<br>}<br>//all getters and setters<br>}<br>//each branch is going to send from cpu to gpu for parallel computing<br>Function **parallelTraverse**(String word,Branch b1) {<br>Node current = b1.root;<br>For(i; i < branch.len; i++) {<br>If(word.equals(node.abbreviations)) {<br>Replace(node.expansion);<br>}<br>Else {<br>current = current.next;<br>}<br>}<br>}|ist<String> abbreviations = sortByLength(listOfAbbreviations);<br>// Create index of corpus<br>Map<String, List<Integer>> index = createIndex(corpusOfText);<br>// Iterate through abbreviations<br>**for** (String abbreviation : abbreviations){<br>// Search index for abbreviation List<Integer> matches =<br>searchIndex(abbreviation, index);<br>// If abbreviation found, use string matching algorithm<br>**if** (matches.size() > 0)<br>{<br>String closestMatch = stringMatchingAlgorithm(abbreviation,<br>matches);<br>// Replace abbreviation with closestMatch<br>corpusOfText = replaceAbbreviation(abbreviation, closestMatch,<br>corpusOfText);<br>}<br>}<br>// Output corpus with abbreviations replaced<br>outputCorpus(corpusOfText);|

The first pseudo-code represents a tree-based approach for abbreviation expansion, where the words are saved in a tree structure with each node containing the abbreviation and its corresponding expansion. The algorithm performs a sequential traversal of the tree, comparing the input word to the abbreviation stored at each node until a match is found, and then replaces the abbreviation with its expansion.

On the other hand, the second pseudo-code represents an index-based approach, where the abbreviations are preprocessed and sorted by length. The algorithm then creates an index of the corpus, mapping each word to its corresponding positions in the text. For each abbreviation in the sorted list, the algorithm searches the index to find any occurrences of the abbreviation in the text. If the abbreviation is found, the algorithm applies a string-matching algorithm to find the closest match to the abbreviation and replaces it with the closest match.

In summary, the first algorithm uses a tree-based approach, while the second algorithm uses an index-based approach. The first algorithm performs a sequential traversal of the tree structure to find the abbreviation, while the second algorithm performs a search on the index to find any occurrences of the abbreviation in the text. The second algorithm also uses a string-matching algorithm to find the closest match to the abbreviation.

### Algorithm Analysis

Algorithm 1 had an important finding, i.e, storing the words in a tree structure can improve efficiency and accuracy when searching for and replacing abbreviations in a large volume of text. By sorting the words alphabetically and using a parallel traversal approach, the algorithm can quickly narrow down the search space and identify the correct expansion for an abbreviation.
Another key insight is that the time complexity of the algorithm is O(n), where n is the number of nodes in the branch. This is due to the use of a for loop in the parallelTraverse function, which iterates through the nodes until either the end of the branch is reached or the word is found and replaced. However, the Insert method of the AbbTree class has a time complexity of O(1), which does not significantly affect the overall time complexity.
In terms of space complexity, the algorithm uses a linked list data structure to store the nodes in the branch, with each node occupying a fixed amount of space. Therefore, the overall space complexity is also O(n).
Overall, this algorithm provides a robust and efficient solution for replacing abbreviations in a large volume of text, with a focus on accuracy and speed.
![](https://github.com/erfan2ubc/Cosc320_Project/blob/main/plots/algorithm1.png)

Algorithm 2 can be analyzed for correctness and time complexity as well. The correctness of the algorithm can be proven by demonstrating that it produces the correct output for all possible inputs. In this case, the algorithm is expected to replace all the abbreviations in the given corpus of text with their respective words or phrases. To prove correctness, one can show that the algorithm searches for each abbreviation in the corpus and replaces it with the correct word or phrase. This ensures that the algorithm produces the expected output for all possible inputs.
To analyze the time complexity of the algorithm, one can count the number of operations performed by the algorithm. The algorithm performs preprocessing operations to create an index of the corpus of text and store the list of abbreviations. Then, it iterates through the abbreviations in the list and searches for each one in the index. For each abbreviation found, a string-matching algorithm is used to find the closest match. Finally, the abbreviation is replaced with the appropriate word or phrase in the corpus.
The time complexity of the algorithm is O(n*m),* where n is the number of abbreviations in the list and m is the length of the corpus. This is because, in the worst-case scenario, the algorithm will have to iterate through each abbreviation in the list and search for it in the corpus, which will require O(nm) operations.
The space complexity of the algorithm is O(n+m) as it requires space to store the list of abbreviations, the index, and the corpus of text.
In conclusion, the given algorithm is a fast and efficient way to replace abbreviations in a corpus of text. The algorithm's correctness can be proven by demonstrating that it produces the correct output for all possible inputs, and its time complexity can be analyzed by counting the number of operations performed by the algorithm, which is O(n\*m). The space complexity of the algorithm is O(n+m).
![](https://github.com/erfan2ubc/Cosc320_Project/blob/main/plots/algorithm2.png)

In comparison, the algorithm analyses of both algorithms (1 & 2) highlight the importance of analyzing the correctness and efficiency of algorithms. In both cases, correctness is established by ensuring that the algorithm produces the correct output for all possible inputs. In the case of the sorting algorithm, the time complexity is used to establish its efficiency, while in the case of the abbreviation replacement algorithm, both time and space complexity are used. The running time of the sorting algorithm is established by analyzing the number of operations required to sort an array of n elements, while the time complexity of the abbreviation replacement algorithm is determined by the number of operations required to process a list of n abbreviations and a corpus of text with m words. Additionally, the space complexity of the abbreviation replacement algorithm is also analyzed, which is not required in the case of the sorting algorithm. Overall, the algorithm analyses of both topics provide valuable insights into the performance of algorithms and highlight the importance of choosing the right algorithm for a given task based on its efficiency and correctness.
Here is a plot comparing the running times of both algorithms-
![](https://cdn.discordapp.com/attachments/1066461807155359776/1095863990095200416/Screenshot_2023-04-12_171207.png)

### Unexpected Cases/Difficulties

The difficulties mentioned for both algorithms are quite similar. One of the main challenges is dealing with abbreviations that have multiple meanings, which requires some form of context-aware technique to determine the correct meaning. Another challenge is dealing with homophones, where the algorithm needs to use a dictionary or other linguistic data to determine the correct word. These difficulties are related to the ambiguity and complexity of human language, which can pose significant challenges in the development of algorithms that process natural language. Overall, both algorithms require careful consideration and handling of these kinds of unexpected cases and difficulties to achieve accurate and reliable results.

### Member contribution to the whole project:
Anna
-Project proposal
-Algorithm 1 - problem formulation, algorithm analysis, implementation, results, unexpected cases/difficulties
-Algorithm 2 - implementation, results, unexpected cases/difficulties
-Video
Erfan 
-Project proposal
-Algorithm 1 - problem formulation, pseudo-code, implementation, results, unexpected cases/difficulties
-Algorithm 2 - algorithm analysis, results
-Plots
Sahil
-Algorithm 2 - problem formulation, pseudo-code 
-Comparison summary



[Link to dataset used](https://drive.google.com/file/d/1wZcJatxJ1zzH7Yut7anq1cZToyKcVChM/view?usp=share_link)
