#include<stdio.h>
#define SIZE 15

int topo [SIZE], step;
void dfs(int [][SIZE], int[], int, int);

int main(){
  int n, i, j, a[SIZE][SIZE], v[SIZE]={0};

  printf("enter no of vertices\n");
  scanf("%d", &n);
  step = n-1;

  printf("enter adjacency matrix\n");
  for(i=0;i<n;i++)
    for(j=0;j<n;j++)
      scanf("%d", &a[i][j]);

  printf("dfs:\n");
  for(i=0;i<n;i++)
    if(v[i]==0)
      dfs(a,v,n,i);

  printf("\ntopological ordering:\n");
  for(i=0;i<n;i++)
    printf("%d\t", topo[i]);

  printf("\n");
}

void dfs(int a[][SIZE], int v[], int n, int source){
  int i;

  v[source]=1;
  printf("%d\t", source);

  for(i=0;i<n;i++)
    if(a[source][i] == 1 && v[i] == 0)
      dfs(a,v,n,i);

  topo[step--] = source;
}
