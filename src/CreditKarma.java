import java.util.*;
import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.


p
1
var _ = require('underscore');
2
​
3
const user = { "id": 356, "name": "Sally", "creditScore": 590, "autoLoan": { "balance": 7900, "termRemaining": 16 } };
4
​
5
const autoLoans = [
6
    {"auto-loan": { "id": 1, "provider": "CapitalOne", "term": 36, "minimumCreditScore": 300, "maximumCreditScore": 700, "maximumAmount": 10000 } },
7
    {"auto-loan": { "id": 2, "provider": "Blue Harbor", "term": 24, "minimumCreditScore": 600, "maximumCreditScore": 700, "maximumAmount": 5000 } },
8
    {"auto-loan": { "id": 3, "provider": "Blue Harbor", "term": 36, "minimumCreditScore": 600, "maximumCreditScore": 700, "maximumAmount": 3500 }  },
9
    {"auto-loan": { "id": 4, "provider": "USAA", "term": 36, "minimumCreditScore": 300, "maximumCreditScore": 900, "maximumAmount": 10000 } }
10
 ];
11
​
12
const creditCards = [
13
    {"credit-card": { "id":1, "provider":"CapitalOne", "minimumCreditScore":300, "maximumCreditScore":700 }},
14
    {"credit-card": { "id":2, "provider":"CapitalOne", "minimumCreditScore":600, "maximumCreditScore":700 }},
15
    {"credit-card": { "id":3, "provider":"Chase", "minimumCreditScore":300, "maximumCreditScore":900 }}
16
];
17
​
18
const personalLoans = [
19
    {"personal-loan": { "id": 1, "provider": "Avant", "term": 36, "minimumCreditScore": 300, "maximumCreditScore": 700, "maximumAmount": 3000 }},
20
    {"personal-loan": { "id": 2, "provider": "Prosper", "term": 24, "minimumCreditScore": 600, "maximumCreditScore": 700, "maximumAmount": 5000 }},
21
    {"personal-loan": { "id": 3, "provider": "Lending Club", "term": 36, "minimumCreditScore": 650, "maximumCreditScore": 800, "maximumAmount": 10000 }}
22
 ];
23
​
24
console.log(user);
25
​
26
function offers(user) {
27
  autoLoans.map(a => a['auto-loan']).forEach(a => {
28
    if (a.minimumCreditScore <= user.creditScore && user.creditScore <= a.maximumCreditScore)     {
29
      console.log(a);
30
    }
31

32
  });
33

34
  creditCards.map(c => c['credit-card']).forEach(c => {
35
    if (c.minimumCreditScore <= user.creditScore && user.creditScore <= c.maximumCreditScore)     {
36
      console.log(c);
37
    }
38
  });
39

40
  personalLoans.map(p => p['personal-loan']).forEach(p => {
41
    if (p.minimumCreditScore <= user.creditScore && user.creditScore <= p.maximumCreditScore)     {
42
      console.log(p);
43
    }
44
  });
45
}
46
​
47
offers(user);
48

49
/*
50
Your previous Java content is preserved below:
51
​
52
import java.io.*;
53
import java.util.*;
54
​
55
/*
56
 * To execute Java, please define "static void main" on a class
57
 * named Solution.
58
 *
59
 * If you need more classes, simply define them inline.
60
 */
61
        ​
        62
/**
 *
 class AutoLoanService {
 // autoLoan: string[];
 constructor(data) {
 this.autoLoans = data
 }

 qualify(user, service) {
 if (service.minimumCreditScore <= user.creditScore && user.creditScore <= service.maximumCreditScore)     {
 console.log(service);
 return service;
 }
 }

 getAll() {
 this.autoLoans.map(a => a['auto-loan']).forEach(a => console.log(a));
 }

 getForUser(user) {
 this.autoLoans.map(a => a['auto-loan']).forEach(a => qualify(user, a));
 }
 }

 new AutoLoanService(autoLoans)
 63
 * A significant part of Credit Karma's platform is identifying well-matched
 64
 * financial offerings for our users based on many factors including a user's
 Start Call

 Ryan Wibawa
 it
 Settings Ryan Wibawa
 */

/**
 * A significant part of Credit Karma's platform is identifying well-matched
 * financial offerings for our users based on many factors including a user's
 * current financial profile. For this test you'll be asked to develop a
 * rudimentary system that does exactly that.
 *
 * The goal of the system is to serve offers to users. You'll develop this
 * in a stepwise manner. Whenever you're asked to serve an offer to the user
 * the implementation should result in the offers being printed to the console.
 *
 * Step 1: Return all of the offers from each service to the user.
 *
 * Step 2: Only return offers from each service where the user's credit score
 * is between (inclusive) the offers minimum and maximum score.
 *
 * Step 3: Serve all relevant offers from step 2 and only the auto loan offers to
 * the user if the user's current outstanding loan is less than or equal to the
 * auto loan offer's maximum amount.
 *
 * User:

 { "id": 356, "name": “Sally”, "creditScore": 590, "autoLoan": { "balance": 7900, "termRemaining": 16 } }
 *
 * Service Data:

 """
 [
 {"auto-loan": { "id": 1, "provider": "CapitalOne", "term": 36, "minimumCreditScore": 300, "maximumCreditScore": 700, "maximumAmount": 10000 },
 {"auto-loan": { "id": 2, "provider": "Blue Harbor", "term": 24, "minimumCreditScore": 600, "maximumCreditScore": 700, "maximumAmount": 5000 },
 {"auto-loan": { "id": 3, "provider": "Blue Harbor", "term": 36, "minimumCreditScore": 600, "maximumCreditScore": 700, "maximumAmount": 3500 },
 {"auto-loan": { "id": 4, "provider": "USAA", "term": 36, "minimumCreditScore": 300, "maximumCreditScore": 900, "maximumAmount": 10000 }
 ]
 """

 """
 [
 {"credit-card": { "id":1, "provider":"CapitalOne", "minimumCreditScore":300, "maximumCreditScore":700 }},
 {"credit-card": { "id":2, "provider":"CapitalOne", "minimumCreditScore":600, "maximumCreditScore":700 }},
 {"credit-card": { "id":3, "provider":"Chase", "minimumCreditScore":300, "maximumCreditScore":900 }}
 ]
 """

 """
 [
 {"personal-loan": { "id": 1, "provider": "Avant", "term": 36, "minimumCreditScore": 300, "maximumCreditScore": 700, "maximumAmount": 3000 },
 {"personal-loan": { "id": 2, "provider": "Prosper", "term": 24, "minimumCreditScore": 600, "maximumCreditScore": 700, "maximumAmount": 5000 },
 {"personal-loan": { "id": 3, "provider": "Lending Club", "term": 36, "minimumCreditScore": 650, "maximumCreditScore": 800, "maximumAmount": 10000 }
 ]
 """

 */

class Solution {
    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<String>();
        strings.add("Hello, World!");
        strings.add("Welcome to CoderPad.");
        strings.add("This pad is running Java 8.");

        for (String string : strings) {
            System.out.println(string);
        }
    }
}

public class CreditKarma {
    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<>();
        strings.add("Hello, World!");
        strings.add("Welcome to CoderPad.");
        strings.add("This pad is running Java 8.");

        for (String string : strings) {
            System.out.println(string);
        }
    }
}
