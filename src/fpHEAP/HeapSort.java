package fpHEAP;

import java.util.Arrays;
  
public class HeapSort implements IFila {
	public int fp[];
	public int position = 0;
	
	public HeapSort() {	}
	

	public HeapSort(int length) {
		this.fp = new int[length];
	}


	@Override
	public void insert(int item) {
		fp[++position] = item;
		this.upHeap(position);
			
	}

	@Override
	public int removeMin() {
		int aux = fp[1];
		this.fp[1] = this.fp[position];
		this.fp[position] = 0;
		position--;
		downHeap(1);
		return aux;
	}

	@Override
	public Object min() {
		return fp[position];
	}

	@Override
	public long size() {
		return Arrays.stream(fp).count();
	}

	@Override
	public boolean isEmpty() {
		return Arrays.stream(fp).count()==0;
	}

	public void upHeap(int son) { 
		int father = son/2;
		if(father >=1) {
			if(this.fp[son] > this.fp[father]) {
				int aux = this.fp[father];
				this.fp[father] = this.fp[son];
				this.fp[son] = aux;
				upHeap(father);
			}
		}
	}
	
	public void downHeap(int father) {
		int left = 2*father;
		int right = left+1;
		int max = father;
		
		if((left <= position) && this.fp[left] > this.fp[max]) {
			max = left;
		}
		
		if((right <= position) && this.fp[right] > this.fp[max]) {
			max= right;
		}
		
		if(max != father) {
			int aux = this.fp[father];
			this.fp[father] = this.fp[max];
			this.fp[max] = aux;
			downHeap(max);
		}
	}
	
	public void print() {
		for(int i=0; i < this.fp.length;i++) {
			System.out.println(this.fp[i]);
		}
	}


	@Override
	public String toString() {
		return "HeapSort [fp=" + Arrays.toString(fp) + "]"+ ", position=" + position ;
	}
	
	
}  
