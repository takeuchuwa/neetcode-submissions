class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Union union = new Union();
        for (List<String> account : accounts) {
            String mainEmail = account.get(1);
            String name = account.get(0);
            if (union.find(mainEmail) == null) {
                union.create(name, mainEmail);
            }
            for (int i = 2; i < account.size(); i++) {
                union.insert(name, mainEmail, account.get(i));
            }
        }

        return union.output();
    }

    class Union {
        
        Map<String, String> emailToParent;
        Map<String, String> parentToAcc;
        Map<String, Set<String>> parentToEmails;
        Map<String, Integer> emailRanks;

        Union() {
            emailToParent = new HashMap<>();
            parentToAcc = new HashMap<>();
            parentToEmails = new HashMap<>();
            emailRanks = new HashMap<>();

        }

        List<List<String>> output() {
            List<List<String>> output = new ArrayList<>();

            for (Map.Entry<String, String> parentAndAcc : parentToAcc.entrySet()) {
                List<String> acc = new ArrayList<>();
                acc.add(parentAndAcc.getValue());
                acc.addAll(parentToEmails.get(parentAndAcc.getKey()));
                output.add(acc);
            }

            return output;
        }

        String create(String name, String email) {
            emailToParent.put(email, email);
            parentToAcc.put(email, name);
            emailRanks.put(email, 0);
            Set<String> emails = new TreeSet<>();
            emails.add(email);
            parentToEmails.put(email, emails);
            return email;
        }

        String find(String email) {
            String parent = emailToParent.get(email);
            while (parent != null && !emailToParent.get(parent).equals(parent)) {
                emailToParent.put(parent, emailToParent.get(parent));
                parent = emailToParent.get(parent);
            }

            return parent;
        }

        void join(String email1, String email2) {
            emailToParent.put(email2, email1);
            parentToEmails.get(email1).add(email2);
        }

        void insert(String name, String email1, String email2) {
            String parent1 = find(email1);
            String parent2 = find(email2);
            if (parent1 == null) {
                parent1 = create(name, email1);
            }
            if (parent2 == null) {
                join(parent1, email2);
                return;
            }

            if (parent1.equals(parent2)) return;

            if (emailRanks.get(parent1) > emailRanks.get(parent2)) {
                emailToParent.put(parent2, parent1);
                Set<String> childEmails = parentToEmails.remove(parent2);
                parentToEmails.get(parent1).addAll(childEmails);
                parentToAcc.remove(parent2);
            } else if (emailRanks.get(parent1) < emailRanks.get(parent2)) {
                emailToParent.put(parent1, parent2);
                Set<String> childEmails = parentToEmails.remove(parent1);
                parentToEmails.get(parent2).addAll(childEmails);
                parentToAcc.remove(parent1);
            } else {
                emailToParent.put(parent1, parent2);
                Set<String> childEmails = parentToEmails.remove(parent1);
                parentToEmails.get(parent2).addAll(childEmails);
                emailRanks.merge(parent2, 1, Integer::sum);
                parentToAcc.remove(parent1);
            }
        }
    }
}