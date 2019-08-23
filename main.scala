//Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists

//Example:
//Input: 1->3->4,  1->2->4
//Output: 1->1->2->3->4->4

// https://leetcode.com/problems/merge-two-sorted-lists/

class ListNode(var _x: Int = 0) {
  var next: ListNode = null
  var x: Int = _x
 }


def mergeTwoSortedLinkedLists(list1: ListNode, list2: ListNode): ListNode = {
  var currentNodeOfList1 = list1.next
  var currentNodeOfList2 = list2
  var resultList = list1
  val firstResultNode = resultList

  println("first node " + firstResultNode.x)

  while (currentNodeOfList2 != null) {

    val currList1Value = currentNodeOfList1.x
    println("currList1NodeVal : " + currList1Value)

    val currList2Value = currentNodeOfList2.x
    println("currList2NodeVal : " + currList2Value)

    if(currList1Value == currList2Value) {
      resultList.next = currentNodeOfList2
      resultList = resultList.next
      currentNodeOfList2 = currentNodeOfList2.next
      println("inside if equals " + resultList.x)

    } else if(currList1Value < currList2Value ) {
      resultList.next = currentNodeOfList1
      resultList = resultList.next
      currentNodeOfList1 = currentNodeOfList1.next
      println("inside if less than " + resultList.x)

    } else {
      resultList.next = currentNodeOfList2
      resultList = resultList.next
      currentNodeOfList2 = currentNodeOfList2.next
      println("inside if greater than " + resultList.x)
    }
  }


  firstResultNode
}

// Setting up the initial linked lists
val node1 = new ListNode(1)
val node2 = new ListNode(3)
val node3 = new ListNode(4)

node1.next = node2
node2.next = node3
node3.next = null

val node4 = new ListNode(1)
val node5 = new ListNode(2)
val node6 = new ListNode(4)

node4.next = node5
node5.next = node6
node6.next = null

val result = mergeTwoSortedLinkedLists(node1, node4)


// Printing the resulting linked list
var curr = result
println(curr.x)
do {
  curr = curr.next
  println(curr.x)
} while(curr.next != null)

