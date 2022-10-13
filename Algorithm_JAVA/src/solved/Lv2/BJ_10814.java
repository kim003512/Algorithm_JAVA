package solved.Lv2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

//정렬
public class BJ_10814 {
    public static void main(String[] args) throws IOException{
        useObject();
    }

    public static void useObject() throws IOException{
        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Person[] p = new Person[n];
        for(int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            
            p[i] = new Person(age, name);   
        }

        Arrays.sort(p, new Comparator<Person>(){
            public int compare(Person p1, Person p2) {
                return p1.age - p2.age;
            }
        });

        StringBuilder sb = new StringBuilder();

        for(int i=0; i<n; i++) {
            //객체 배열의 객체를 출력하면 해당 인덱스의 객체의 toString()이 출력
            sb.append(p[i]);
        }

        System.out.println(sb);
    }

    public static class Person {
        int age;
        String name;

        public Person(int age, String name) {
            this.age = age;
            this.name = name;
        }

        public String toString() {
            return age + " " + name + '\n';
        }
    }

    public void userCompare() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String[][] people = new String[n][2];

        for(int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            people[i][0] = st.nextToken();
            people[i][1] = st.nextToken();

            
        }
        Arrays.sort(people, new Comparator<String[]>(){
            public int compare(String[] s1, String[] s2) {
                return Integer.parseInt(s1[0]) -Integer.parseInt(s2[0]);
            }
        });

        StringBuilder sb = new StringBuilder();

        for(String[] str : people) {
            sb.append(str[0]).append(' ').append(str[1]).append('\n');
        }

        System.out.print(sb);
    }
}
