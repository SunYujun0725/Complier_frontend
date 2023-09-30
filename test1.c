void main()
{

   float d;
   float e;
   float f;
   int a;
   int b;
   int c;
   
   a = 0;
   b = 10;
   d = 2.34;
   e = 3.34;
	
   /*add(int, float)*/
   c = a + b;
   printf("%d\n",c);
   c = a + 100;
   printf("%d\n",c);
   c = 100 + a;
   printf("%d\n",c);
   c = 3 + 5;
   printf("%d\n",c);
   f = d + e;
   printf("%f\n",f);
   f = d + 1.2;
   printf("%f\n",f);
   f = 1.2 + d;
   printf("%f\n",f);
   f = 2.34+3.34;
   printf("%f\n",f);
   
   
   //sub(int, float)
   c = a - b;
   printf("%d\n",c);
   c = a - 5;
   printf("%d\n",c);
   c = 5 - a;
   printf("%d\n",c);
   c = 3 - 5;
   printf("%d\n",c);
   f = d - e;
   printf("%f\n",f);
   f = d - 1.2;
   printf("%f\n",f);
   f = 1.2 - d;
   printf("%f\n",f);
   f = 2.34 - 1.3;
   printf("%f\n",f);
   
   //mul(int, float)
   c = a * b;
   printf("%d\n",c);
   c = a * 5;
   printf("%d\n",c);
   c = 5 * a;
   printf("%d\n",c);
   c = 3 * 5;
   printf("%d\n",c);
   f = d * e;
   printf("%f\n",f);
   f = d * 1.2;
   printf("%f\n",f);
   f = 1.2 * d;
   printf("%f\n",f);
   f = 2.34 * 1.3;
   printf("%f\n",f);

   //div(int, float) 
   c = a / b;
   printf("%d\n",c);
   c = a / 5;
   printf("%d\n",c);
   c = 5 / b;
   printf("%d\n",c);
   c = 3 / 5;
   printf("%d\n",c);
   f = d / e;
   printf("%f\n",f);
   f = d / 1.2;
   printf("%f\n",f);
   f = 1.2 / d;
   printf("%f\n",f);
   f = 2.34 / 1.3;
   printf("%f\n",f);
   
   /*四則運算*/
   a = b+2*(100-1);
   f = d*2.34 + (1.2+2.0);
   //c = a;  error
   //b = a + c;  error
   printf("%d\n",a);
   printf("%f\n",f);
   
   a = b + c*(100-2) +2*3/2;
   printf("%d\n",a);
   f = d + e*(1.3-4.5) +5.2*1.2/4.3;
   printf("%f\n",f);
   
   a = -a;
   printf("%d\n",a);
   
   f = -f;
   printf("%f\n",f);
   
   printf("%d\n",-a);
   printf("%f\n",-f);
   
}
