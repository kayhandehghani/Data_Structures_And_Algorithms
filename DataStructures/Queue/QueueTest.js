require('./Queue');

var q = new Queue();
q.print();
console.log(q.isEmpty());

q.enqueue(7);
q.enqueue("second");
q.enqueue([6, 8]);

q.print();
console.log(q.isEmpty());
console.log(q.dequeue());
console.log(q.dequeue());
console.log(q.dequeue());
q.print();
console.log(q.dequeue());
console.log(q.isEmpty());
q.enqueue(88);
q.enqueue(99);
q.enqueue([6, 8]);
q.print();
console.log(q.isEmpty());
console.log(q.clear())
console.log(q.isEmpty());
q.print();
q.enqueue(88);
q.enqueue(99);
q.enqueue([6, 8]);
console.log(q.dequeue());
console.log(q.dequeue());
console.log(q.dequeue());
q.print();
