/**
* @summary: simple implementation of a Queue(FIFO) using two stacks as underlying data structure.
* @author: Kayhan Dehghani
**/
let process = require('process');


// constructor
Queue = function() {
	this.pushStack = []; // stack on which enqueue() is performed
	this.popStack = []; // stack on which dequeue() is performed
};


Queue.prototype.enqueue = function(obj) {
	this.pushStack.push(obj);
};

Queue.prototype.dequeue = function() {
	/* 
	* if there is nothing to pop from popStack copy everything from pushStack
	* to popoStack in reverse order and empty pushStack.
	*/
	if(this.popStack.length == 0) {
		this.popStack = this.pushStack.reverse();
		this.pushStack = [];
	}
	return this.popStack.pop();
};

Queue.prototype.isEmpty = function() {
	return this.pushStack.length == 0 && this.popStack.length == 0;
};

Queue.prototype.clear = function() {
	this.popStack = [];
	this.pushStack = [];
};

Queue.prototype.print = function() {
	process.stdout.write("{ ");
	this.popStack.forEach(function(element) {
		process.stdout.write(`(${element}) `);
	});
	this.pushStack.forEach(function(element) {
		process.stdout.write(`(${element}) `);
	});
	process.stdout.write(" }\n");
};