import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int N;
    static boolean[] visited;
    static char[][] tree;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        tree = new char[N][3];

        for(int n=0; n<N; n++){
            st = new StringTokenizer(br.readLine());
            char p = st.nextToken().charAt(0);
            int idx = p-'A';

            tree[idx][0] = p;
            tree[idx][1] = st.nextToken().charAt(0);
            tree[idx][2] = st.nextToken().charAt(0);
        }

        preorder(0);
        sb.append("\n");
        inorder(0);
        sb.append("\n");
        postorder(0);

        System.out.println(sb);
    }

    public static void preorder(int i){
        if( i < 0 || i >= N) return;

        sb.append(tree[i][0]);
        preorder(tree[i][1]-'A');
        preorder(tree[i][2]-'A');
    }

    public static void inorder(int i){
        if( i < 0 || i > N) return;

        inorder(tree[i][1]-'A');
        sb.append(tree[i][0]);
        inorder(tree[i][2]-'A');
    }

    public static void postorder(int i){
        if( i < 0 || i > N) return;

        postorder(tree[i][1]-'A');
        postorder(tree[i][2]-'A');
        sb.append(tree[i][0]);
    }
}
