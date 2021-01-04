package FuckingAlgorithm.UnionFind;

import java.util.*;

/**
 * leetcode 721 账户合并
 */
public class AccountsMerge {

    public static void main(String[] args) {
        String name = "John";
        String email1 = "johnsmith@mail.com";
        String email2 = "john00@mail.com";
        String email3 = "aaa@mail.com";
        String email4 = "bbb@mail.com";



        List<String> account1 = new ArrayList<>();
        account1.add(name);
        account1.add(email1);
        account1.add(email2);
        account1.add(email3);
        account1.add(email4);


//        String name2 = "John";
//        String email21 = "johnnybravo@mail.com";
//        String email22 = "john00@mail.com";
//
//        List<String> account2 = new ArrayList<>();
//        account2.add(name2);
//        account2.add(email21);
//        account2.add(email22);

        List<List<String>> accounts = new ArrayList<>();
        accounts.add(account1);
        //accounts.add(account2);

        List<List<String>> lists = accountsMerge(accounts);
        System.out.println(lists);


    }

    public static List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, String> emailToName = new HashMap<>();
        Map<String, ArrayList<String>> graph = new HashMap();

        for (List<String> account : accounts) {
            String name = "";
            for (String email : account) {
                if (name == "") {
                    name = email;
                    continue;
                }
                graph.computeIfAbsent(email,x-> new ArrayList<String>()).add(account.get(1));
                graph.computeIfAbsent(account.get(1),x->new ArrayList<>()).add(email);
                emailToName.put(email,name);
            }
        }

        Set<String> seen = new HashSet();
        List<List<String>> ans = new ArrayList();
        for (String email: graph.keySet()) {
            if (!seen.contains(email)) {
                seen.add(email);
                Stack<String> stack = new Stack();
                stack.push(email);
                List<String> component = new ArrayList();
                while (!stack.empty()) {
                    String node = stack.pop();
                    component.add(node);
                    for (String nei: graph.get(node)) {
                        if (!seen.contains(nei)) {
                            seen.add(nei);
                            stack.push(nei);
                        }
                    }
                }
                Collections.sort(component);
                component.add(0, emailToName.get(email));
                ans.add(component);
            }
        }

        return ans;
    }


}
