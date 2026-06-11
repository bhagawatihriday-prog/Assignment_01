# Assignment 14
# Demonstrating Cyclic References and Garbage Collection in Python

import sys
import gc


class Node:
    def __init__(self, name):
        self.name = name
        self.link = None

    def __del__(self):
        print(f"{self.name} is being garbage collected")


# Disable automatic garbage collection
# so we can clearly observe the cycle
gc.disable()

print("=== Creating Objects ===")

A = Node("Node A")
B = Node("Node B")

# Create cyclic reference
A.link = B
B.link = A

print("Cycle created:")
print("A ->", A.link.name)
print("B ->", B.link.name)

print("\n=== Reference Counts ===")

# sys.getrefcount() adds one temporary reference itself
print("Reference count of A:", sys.getrefcount(A))
print("Reference count of B:", sys.getrefcount(B))

print("\n=== Deleting Main References ===")

# Keep object IDs for investigation
a_id = id(A)
b_id = id(B)

# Delete external references
del A
del B

print("A and B variables deleted")

print("\n=== Investigation Before Garbage Collection ===")

# Objects still exist because they reference each other
found = False

for obj in gc.get_objects():
    if id(obj) == a_id or id(obj) == b_id:
        print("Object still exists in memory:", obj.name)
        found = True

if not found:
    print("Objects not found")

print("\n=== Forcing Garbage Collection ===")

unreachable = gc.collect()

print("Unreachable objects collected:", unreachable)

print("\n=== Investigation After Garbage Collection ===")

found = False

for obj in gc.get_objects():
    if id(obj) == a_id or id(obj) == b_id:
        print("Object still exists:", obj.name)
        found = True

if not found:
    print("Cycle successfully removed from memory")

# Re-enable automatic garbage collection
gc.enable()