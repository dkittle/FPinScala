import chapter3.{Branch, Leaf, Tree}

Tree.size(Branch(Leaf(1), Leaf(2)))

Tree.size(Leaf(99))

Tree.size(Branch(Branch(Leaf(0), Leaf(123)), Branch(Leaf(2), Leaf(4))))


Tree.sum(Leaf(12))

Tree.sum(Branch(Leaf(2), Leaf(3)))


Tree.sum(Branch(Branch(Leaf(0), Leaf(123)), Branch(Leaf(2), Leaf(4))))

Tree.depth(Leaf(13))

Tree.depth(Branch(Leaf(43), Branch(Leaf(1), Leaf(2))))


Tree.depth(Branch(Branch(Leaf(1), Branch(Leaf(2), Leaf(3))), Branch(Leaf(14), Leaf(15))))

