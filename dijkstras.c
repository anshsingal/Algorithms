#include<stdio.h>
#include<stdlib.h>

int* dijkstras(int adj[20][20], int s, int n);
int find_min(int dist[], int visited[], int n, int max_dist);

int main(){
  int n, i, j, adj[20][20], s, *dist;
  printf("enter no of nodes in graph\n");
  scanf("%d", &n);
  printf("enter adjecency matrix with weights\n");
  for(i=0;i<n;i++)
    for(j=0;j<n;j++)
      scanf("%d", &adj[i][j]);
  printf("select source index\n");
  scanf("%d", &s);
  dist=dijkstras(adj, s, n);
  printf("distances of %d from other vertices are:\n");
  for(i=0;i<n;i++)
    printf("dist to %d = %d\n", i, *(dist+i));
}

int* dijkstras(int adj[20][20], int s, int n){
  int visited[20], i, u, max_dist=0, j, temp_dist[20];
  int *dist=(int*)malloc(20*sizeof(int));
  for(i=0;i<n;i++)
    for(j=i+1;j<n;j++)
      max_dist+=adj[i][j];
  for(i=0;i<n;i++){
    *(dist+i)=max_dist+1;
    visited[i]=0;
    //printf("dist %d:%d\n", i, dist[i]);
  }
  dist[s]=0;
  for(i=0;i<n;i++){
    u=find_min(dist, visited, n, max_dist);
    //printf("smallest vertex:%d\n", u);
    if(u==-1)
      break;
    visited[u]=1;
    for(j=0;j<n;j++){
      if(adj[u][j]!=0 && *(dist+j)>*(dist+u)+adj[u][j]){
        *(dist+j)=*(dist+u)+adj[u][j];
      }
    }
  }
  //for(i=0;i<n;i++)
  //  printf("dist of %d from %d = %d\n", i, s, dist[i]);
  return dist;
}

int find_min(int dist[], int visited[], int n, int max_dist){
  int i, min=-1, min_dist=max_dist;
  for(i=0;i<n;i++){
    if(dist[i]<min_dist && visited[i]==0){
      min_dist=dist[i];
      min=i;
    }
  }
  return min;
}
