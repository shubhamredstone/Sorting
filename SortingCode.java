
public class Main
{
    
    public static void Conqure(int arr[],int si,int mid,int ei)
    {
        int []merged=new int[ei-si+1];
        
        int x=0;
        int idx1=si;
        int idx2=mid+1;
        
        while(idx1<=mid && idx2<=ei)
        {
            if(arr[idx1]<=arr[idx2])
            {
                merged[x++]=arr[idx1++];
            }
            else
            {
                merged[x++]=arr[idx2++];
            }
        }
        while(idx1<=mid)
        {
            merged[x++]=arr[idx1++];
        }
        while(idx2<=ei)
        {
           merged[x++]=arr[idx2++]; 
        }
        
        
        for(int i=0,j=si;i<merged.length;i++,j++)
        {
            arr[j]=merged[i];
        }
    }
    
    public static void SelectionSort(int arr[],int n)
    {
        for(int i=0;i<n;i++)
        {
            int min=i;
            for(int j=i+1;j<n;j++)
            {
                if(arr[min]>arr[j])
                {
                    min=j;
                }
            }
            int t=arr[min];
            arr[min]=arr[i];
            arr[i]=t;
        }
    }
    
    public static void InsertionSort(int arr[],int n)
    {
        for(int i=1;i<n;i++)
        {
            int j=i-1;
            int key=arr[i];
            while(j>=0&& key<arr[j])
            {
                arr[j+1]=arr[j];
                j--;
            }
            arr[j+1]=key;
        }
    }
    
    public static void BubbleSort(int arr[],int n)
    {
        for(int i=0;i<n-1;i++)
        {
            for(int j=0;j<n-i-1;j++)
            {
                if(arr[j]>arr[j+1])
                {
                    int t=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=t;
                }
            }
        }
    }
    
    public static int Partision(int arr[],int low,int high)
    {
        int pivot=arr[high];
        int i=low-1;
        
        for(int j=low;j<high;j++)
        {
            if(arr[j]<pivot)
            {
                i++;
                int t=arr[i];
                arr[i]=arr[j];
                arr[j]=t;
            }
        }
        //swap Pivot
        i++;
        int t=arr[i];
        arr[i]=arr[high];
        arr[high]=t;
        return i;
    }
    
    public static void QuickSort(int arr[],int low,int high)
    {
        if(low<high)
        {
            int Pidx=Partision(arr,low,high);
            
            QuickSort(arr,low,Pidx-1);
            QuickSort(arr,Pidx+1,high);
        }
    }
    
    
    public static void print(int arr[],int n)
    {
        for(int i=0;i<n;i++)
        {
            System.out.print(arr[i]+" ");
        }
    }
    
    public static void Divide(int arr[],int si,int ei)
    {
        if(si>=ei)
        {
            return;
        }
        
        int mid=si+(ei-si)/2;
        
        Divide(arr,si,mid);
        Divide(arr,mid+1,ei);
        Conqure(arr,si,mid,ei);
    }
    
    
	public static void main(String[] args) {
	
	int arr[]={5,1,7,3,9,12,6};
	int n=arr.length;
	Divide(arr,0,n-1);
	print(arr,n);
	System.out.println();
	SelectionSort(arr,n);
	print(arr,n);
	System.out.println();
	InsertionSort(arr,n);
	print(arr,n);
	System.out.println();
	BubbleSort(arr,n);
	print(arr,n);
	System.out.println();
	QuickSort(arr,0,n-1);
	print(arr,n);
	
	}
}
