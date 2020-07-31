#include<stdio.h>
#define SIZE 10
int main(){
  int i, n, j, indeg[SIZE]={0}, adj[SIZE][SIZE], result[SIZE], res_count=0, completed[SIZE]={0};
  printf("enter no of  vertices:\n");
  scanf("%d",&n);
  printf("Enter adjacency matrix:\n");
  for(i=0;i<n;i++){
    for(j=0;j<n;j++){
      scanf("%d",&adj[i][j]);
      if(adj[i][j]==1)
        indeg[j]++;
    }
  }
  while(res_count<n){
    for(i=0;i<n;i++){
      if(indeg[i]==0 && completed[i]!=1){
        result[res_count++]=i;
        for(j=0;j<n;j++){
          if(adj[i][j]==1){
            adj[i][j]=0;
            indeg[j]--;
          }
        }
        completed[i] = 1;
      }
    }
  }
  printf("Order:\n");
  for(i=0;i<n;i++)
    printf("%d\t",result[i]);
  return 0;
}
