package FuckingAlgorithm.UnionFind;

import java.util.*;

/**
 * leetcode 721 账户合并
 */
public class AccountsMerge {

    public static void main(String[] args) {
        List<List<String>> accounts = new ArrayList<>();
        List<String> account1 = Arrays.asList("John", "johnsmith@mail.com", "john00@mail.com");
        List<String> account2 = Arrays.asList("John", "johnnybravo@mail.com");
        List<String> account3 = Arrays.asList("John", "johnsmith@mail.com", "john_newyork@mail.com");
        List<String> account4 = Arrays.asList("Mary", "mary@mail.com");

        accounts.add(account1);
        accounts.add(account2);
        accounts.add(account3);
        accounts.add(account4);

        List<List<String>> lists = accountsMerge(accounts);
        System.out.println(lists);

    }

    public static List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, String> emailToName = new HashMap<>();
        Map<String, List<String>> graph = new HashMap();

        for (List<String> account : accounts) {
            String name = "";
            for (String email : account) {
                if (name == "") {
                    name = email;
                    continue;
                }
                graph.computeIfAbsent(email,x-> new ArrayList<>()).add(account.get(1));
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
