void main()
{

  
   int a;
   int b;
   float c;
   float d;

   a = 0;
   b = 10;
   a = b+2*(100-1);
   c = 2.34;
   d = 2.3*5.3;
   d = -d;
   
   if(a>b){
   	a=a+1;
   	printf("%d\n",a);
   }
   else{
   	b=b+1;
   	printf("%d\n",b);
   }
   
   if(c>=0.0){
   	//printf("c > 0.0 %f",a); error
   	printf("c >= 0.0 %f\n",c);
   }
   
   c = c + 2.5;
   
   if(c<10.0){
   	printf("c < 10.0 %f\n",c);
   }
   
   if(d<=0.0){
   	printf("d <= 0.0 %f\n",d);
   }
   else{
   	printf("d > 0.0%f\n",d);
   }
   
   a = 0;
   b = 0;
   if(a==b){
   	printf("a = b\n");
   }
   
   b = -5;
   if(a!=b){
   	printf("a!=b\n");
   }
   
   c = -2.34;
   printf("%f\n",c);
   
   d = 2.5;
   if(c!=d){
   	printf("c != d\n");
   }
   c = d;
   if(c==d){
   	printf("c == d\n");
   }
   
   
}
