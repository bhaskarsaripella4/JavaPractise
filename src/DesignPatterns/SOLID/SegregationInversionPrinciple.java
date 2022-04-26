package DesignPatterns.SOLID;

/* Interfaces must be small and such that when other classes implement them
* they do not have to implement methods that they do not need. I.e. methods that
* are not required if present must not have no functionality.
* Ex: interface print -> print, scan, fax methods
* Class Multifunciton printer uses all
* class OldFashionedPrinter has only print. Then fax and scan are empty methods. This must be avoided
* Instead make three interfaces Printer, Scanner, Fax and implement all three or one as necessary. This is SIP */

public class SegregationInversionPrinciple {
    public static void main(String[] args) {

    }
}
