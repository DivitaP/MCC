#include<bits/stdc++.h>
using namespace std;

void showCells()
{
	int a = 0;
	for(int i=0; i<30 ; i++)
	{
		if (i%2 != 0)
			cout<<"\t";

		for(int j=0; j< 10; j++)
		{
			cout<<a++<<"\t\t";
		}
		cout<<"\n";
	}
	
}

int cocell1(int base ,int i, int j)
{
	int a = base+i;
	for( int k=0 ; k<j ; k++)
	{
		if(k%2 == 0)
		{
			a -= 9;
		}
		else
			a -= 10;
	}

	return a;
}


int cocell2(int base ,int i, int j)
{
	int a = base;
	for( int k=0 ; k<i ; k++)
	{
		if(k%2 == 0)
			a -= 9;
		else
			a -= 10;
	}

	if (i%2 == 0)
	{
		for(int k=0 ; k<j ; k++)
		{
			if(k%2 == 0)
				a -= 10;
			else
				a -= 11;
		}
		return a;
	}
	else
	{
		for(int k=0 ; k<j ; k++)
		{
			if(k%2 == 0)
				a -= 11;
			else
				a -= 10;
		}
		return a;
	}
}


int cocell3(int base ,int i, int j)
{
	int a = base;
	for( int k=0 ; k<i ; k++)
	{
		if(k%2 == 0)
			a -= 10;
		else
			a -= 11;
	}

	a -= j;
	return a;
}


int cocell4(int base ,int i, int j)
{
	int a = base-i;
	for( int k=0 ; k<j ; k++)
	{
		if(k%2 == 0)
		{
			a += 10;
		}
		else
			a += 9;
	}

	return a;
}


int cocell5(int base ,int i, int j)
{
	int a = base;
	for( int k=0 ; k<i ; k++)
	{
		if(k%2 == 0)
			a += 10;
		else
			a += 9;
	}
	if (i%2 == 0)
	{
		for( int k=0 ; k<j ; k++)
		{
			if(k%2 == 0)
				a += 11;
			else
				a += 10;
		}
		return a;
	}

	else
	{
		for( int k=0 ; k<j ; k++)
		{
			if(k%2 == 0)
				a += 10;
			else
				a += 11;
		}
		return a;
	}
}


int cocell6(int base ,int i, int j)
{
	int a = base;
	for( int k=0 ; k<i ; k++)
	{
		if(k%2 == 0)
			a += 11;
		else
			a += 10;
	}

	a += j;
	return a;
}

int main()
{
	int i,j,n;
	int a1,a2,a3,a4,a5,a6;
	int base;
	showCells();
	cout<<"Enter values of i&j :";
	cin>>i>>j;
	n = i*i+i*j+j*j;
	cout<<"N : "<<n<<endl;
    cout<<"Enter base :";
	cin>>base;
	cout<<"Base : "<<base<<endl;
	

	int c1 = cocell1(base,i,j);
	cout<<"c1 :"<<c1<<endl;
	int c2 = cocell2(base,i,j);
	cout<<"c2 :"<<c2<<endl;
	int c3 = cocell3(base,i,j);
	cout<<"c3 :"<<c3<<endl;
	int c4 = cocell4(base,i,j);
	cout<<"c4 :"<<c4<<endl;
	int c5 = cocell5(base,i,j);
	cout<<"c5 :"<<c5<<endl;
	int c6 = cocell6(base,i,j);
	cout<<"c6 :"<<c6<<endl;

	cout<<"Enter the value of c1 to c6 :";
	cin>>a1>>a2>>a3>>a4>>a5>>a6;

	int score = 0;
	if(a1 == c1)
		score++;
	if(a2 == c2)
		score++;
	if(a3 == c3)
		score++;
	if(a4 == c4)
		score++;
	if(a5 == c5)
		score++;
	if(a6 == c6)
		score++;
	cout<<"Your Score is :"<<score;
	return 0;
} 