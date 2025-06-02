# AllForOne – O(1) Data Structure Implementation

This project contains a Java implementation of the `AllForOne` interface, which supports real-time tracking of string frequencies with **O(1)** time complexity for all operations.

## 👨‍💻 Developed By

**Zeeshan Shah Syed**  
DevOps & Cloud Engineer | 9+ years experience in building scalable, secure, and highly available infrastructure.

## ✨ Features

- ✅ `incrementKey(String key)` – Increases the frequency of a key, or adds it with frequency 1.
- ✅ `decrementKey(String key)` – Decreases the frequency of a key, or removes it if frequency reaches 0.
- ✅ `getMaxKey()` – Retrieves any key with the highest frequency.
- ✅ `getMinKey()` – Retrieves any key with the lowest frequency.

## ⚙️ How It Works

The data structure is optimized using:

- A **doubly linked list** to maintain frequency buckets in order.
- A **HashMap** to quickly access the frequency node for any key.
- Each bucket node holds a **set of keys** that share the same frequency.

This ensures:
- Constant time operations even with many keys.
- Easy access to the most or least frequent keys.

## 📌 Example Usage

```java
AllForOne ds = new AllForOneImpl();
ds.incrementKey("foo");
ds.incrementKey("foo");
ds.incrementKey("bar");
System.out.println(ds.getMaxKey()); // "foo"
System.out.println(ds.getMinKey()); // "bar"

📈 Time Complexity
All operations run in O(1) time:
incrementKey – O(1)
decrementKey – O(1)
getMaxKey – O(1)
getMinKey – O(1)

🛠️ Tech Stack
Java
Data Structures: HashMap, Doubly Linked List, HashSet

📂 Repo Structure
cpp
Copy
Edit
AllForOneImpl.java   // Main implementation
README.md            // Project details

📬 Contact
Feel free to connect with me on LinkedIn: https://www.linkedin.com/in/syed-s-2a3638264/ or reach out at zeeshanshahsyed14@gmail.com for collaboration or questions!
