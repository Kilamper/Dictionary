# Dictionary (Diccionario)

A Java implementation of a hash table-based dictionary data structure with key-value pairs. This implementation uses separate chaining with linked lists for collision resolution and maintains insertion order through a doubly-linked list.

## Project Overview

This project implements a custom dictionary (hash map) data structure in Java that supports generic Object types for both keys and values. The implementation combines the efficiency of hash tables with the order preservation of linked lists.

## Authors

- Armas Pérez, Kilian
- Carballo Ramos, Pablo
- Cruz Pérez, Saúl Antonio

## Features

- **Dynamic resizing**: Automatically expands capacity when load factor reaches 80%
- **Insertion order preservation**: Maintains the order in which elements were added
- **Collision handling**: Uses open addressing for collision resolution
- **Generic implementation**: Supports any Object type for keys and values
- **Comprehensive API**: Python dict-like methods for easy usage

## Project Structure

```
Dictionary/
├── src/
│   ├── Main.java              # Test suite runner
│   ├── source/
│   │   ├── Diccionario.java   # Main dictionary implementation
│   │   └── Node.java          # Node class for linked list
│   └── tests/
│       ├── TestEmptyDict.java       # Tests for empty dictionary
│       ├── TestOneDict.java         # Tests for single-element dictionary
│       ├── TestTwoDict.java         # Tests for two-element dictionary
│       ├── TestManyItemsDict.java   # Tests for multi-element dictionary
│       └── TestTwoHundredDict.java  # Tests for large dictionary (200 elements)
├── lib/
│   ├── junit-4.13.2.jar       # JUnit testing framework
│   └── hamcrest-core-1.3.jar  # Hamcrest matchers for JUnit
└── bin/                        # Compiled class files (generated)
```

## Data Structure Implementation

### Node Class

The `Node` class represents individual key-value pairs in the dictionary:
- Contains a key (immutable) and value (mutable)
- References to next and previous nodes for doubly-linked list
- Supports generic types `<K, V>`

### Diccionario Class

The `Diccionario` class implements the hash table:
- **Default capacity**: 16 buckets
- **Load factor threshold**: 80% (triggers automatic resizing)
- **Hash function**: Uses `(key.hashCode() & 0xfffffff) % buckets.length`
- **Collision resolution**: Open addressing with linear probing
- **Order tracking**: Maintains first and last node references

## API Reference

### Constructors

```java
Diccionario()                 // Creates dictionary with default capacity (16)
Diccionario(int capacity)     // Creates dictionary with specified capacity
```

### Core Methods

#### add(Object key, Object value)
Adds a key-value pair to the dictionary. If the key already exists, updates its value.

```java
d.add("Madrid", 14);
d.add("Barcelona", 5);
```

#### get(Object key)
Returns the value associated with the key, or null if not found.

```java
Object value = d.get("Madrid");  // Returns 14
```

#### get(Object key, Object defaultValue)
Returns the value associated with the key, or the default value if not found.

```java
Object value = d.get("Unknown", "Not found");  // Returns "Not found"
```

#### pop(Object key)
Removes and returns the value associated with the key. Prints error message if key not found.

```java
Object value = d.pop("Madrid");  // Returns 14 and removes the entry
```

#### pop(Object key, Object defaultValue)
Removes and returns the value associated with the key, or returns default value if not found.

```java
Object value = d.pop("Unknown", "Not found");  // Returns "Not found"
```

#### popitem()
Removes and returns the last added key-value pair as a Node object.

```java
Node<Object, Object> lastItem = d.popitem();
```

#### remove(Object key)
Removes the key-value pair and returns true if found, false otherwise.

```java
boolean removed = d.remove("Madrid");  // Returns true if removed
```

#### setdefault(Object key, Object value)
Adds key-value pair if key doesn't exist (returns null). If key exists, returns its current value.

```java
Object existing = d.setdefault("Madrid", 14);  // Returns existing value or null
```

#### clear()
Removes all key-value pairs from the dictionary.

```java
d.clear();
```

#### copy()
Creates a shallow copy of the dictionary.

```java
Diccionario copy = d.copy();
```

#### update(Diccionario other)
Updates the dictionary with key-value pairs from another dictionary.

```java
d.update(otherDict);
```

### Query Methods

#### size()
Returns the number of key-value pairs in the dictionary.

```java
int count = d.size();
```

#### items()
Returns a 2D array containing all key-value pairs.

```java
Object[][] items = d.items();
// items[i][0] = key, items[i][1] = value
```

#### keys()
Returns an array containing all keys in insertion order.

```java
Object[] keys = d.keys();
```

#### values()
Returns an array containing all values in insertion order.

```java
Object[] values = d.values();
```

#### toString()
Returns a string representation of the dictionary in format `{key1 : value1, key2 : value2}`.

```java
String str = d.toString();  // "{Madrid : 14, Barcelona : 5}"
```

#### equals(Object obj)
Compares two dictionaries for equality (same elements in same order).

```java
boolean isEqual = d1.equals(d2);
```

## Building the Project

### Prerequisites
- Java 17 or higher
- JUnit 4.13.2 (included in `lib/`)

### Compilation

```bash
javac -cp "lib/*:src" -d bin src/source/*.java src/tests/*.java src/Main.java
```

### Running Tests

```bash
java -cp "lib/*:bin" Main
```

Expected output:
```
JUnit version 4.13.2
...
OK (26 tests)
```

## Usage Examples

### Basic Operations

```java
import source.Diccionario;

// Create a new dictionary
Diccionario dict = new Diccionario();

// Add elements
dict.add("Madrid", 14);
dict.add("Barcelona", 5);
dict.add("Milan", 7);

// Get values
Object value = dict.get("Madrid");  // Returns 14

// Check size
int size = dict.size();  // Returns 3

// Print dictionary
System.out.println(dict);  // {Madrid : 14, Barcelona : 5, Milan : 7}
```

### Advanced Operations

```java
// Update existing value
dict.add("Madrid", 15);  // Updates value to 15

// Remove element
Object removed = dict.pop("Barcelona");  // Returns 5

// Get all keys
Object[] keys = dict.keys();

// Get all values
Object[] values = dict.values();

// Get all items
Object[][] items = dict.items();

// Copy dictionary
Diccionario copy = dict.copy();

// Update with another dictionary
Diccionario other = new Diccionario();
other.add("Bayern", 6);
dict.update(other);

// Clear all elements
dict.clear();
```

## Test Coverage

The project includes comprehensive test suites:

- **TestEmptyDict**: Tests operations on empty dictionaries
- **TestOneDict**: Tests with a single element
- **TestTwoDict**: Tests with two elements including update operations
- **TestManyItemsDict**: Tests with 8 elements covering all methods
- **TestTwoHundredDict**: Stress tests with 200 elements

Total: 26 test cases covering all functionality

## Technical Details

### Time Complexity

- **add()**: O(1) average, O(n) worst case (when resizing)
- **get()**: O(1) average, O(n) worst case
- **pop()**: O(1) average, O(n) worst case
- **remove()**: O(1) average, O(n) worst case
- **size()**: O(1)
- **clear()**: O(1)
- **copy()**: O(1) (shallow copy)
- **items()**: O(n)
- **keys()**: O(n)
- **values()**: O(n)

### Space Complexity

- O(n) where n is the number of key-value pairs
- Additional overhead for maintaining doubly-linked list structure

## VS Code Configuration

The project includes VS Code settings in `.vscode/settings.json`:
- Source path: `src`
- Output path: `bin`
- Referenced libraries: `lib/**/*.jar`

## License

This is an academic project developed as part of a data structures course.

## Notes

- The implementation prints bucket indices during insertion (line 55 in Diccionario.java) for debugging purposes
- Keys are immutable once added (cannot change the key itself)
- Values can be updated by adding the same key with a new value
- The dictionary maintains insertion order, making it similar to Python's OrderedDict or Java's LinkedHashMap
