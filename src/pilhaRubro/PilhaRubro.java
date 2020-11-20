package pilhaRubro;

import java.util.Arrays;

public class PilhaRubro implements PilhaRN{
	private Object S[];
	private int tr =-1;
	private int tn = 0;

	public PilhaRubro(int tamanho) {
		S = new Object[tamanho];
		tn = S.length;
	}
	
	@Override
	public int size() {
		return tr+tn;
	}
	@Override
	public boolean isEmpty() {
		return tr==-1 ? true : false;
	}
	@Override
	public Object topRubro() {
		return S[tr];
	}
	@Override
	public void pushRubro(Object o) throws Exception {
		if(tr==S.length-1 || tr == tn-1) {
			Object temp[] = new Object[S.length*2];
			//for de iteração rubro 
			for(int i = 0; i<=tr; i++) {
				temp[i] = S[i];
			}
			
			//for de iteração negro
			for(int i = temp.length-1; i > 0; i--) {
				//verifica se [tn] e menor que a pilha original para iterar no novo array, passando pelos elementos [N] do array até o tamanho final do array 
				if(tn<= S.length-1) {
					temp[i] = S[tn];
					tn++;
				}else { //Quando o total de elementos [N] já estiverem no novo array e necessário atualizar o topo tn 
					tn = i+1;
					break;
				}
			}
			S = temp;
		}
		tr = tr+1;
		S[tr] = o;
		
	}
	@Override
	public Object popRubro() throws Exception {
		if(isEmpty())
			throw new Exception("Pilha vazia");
		
		Object temp = S[tr];
		S[tr] = null;
		tr = tr-1;
		return temp;
	}
	
	@Override
	public Object topNegor() {
		return S[tn];
	}
	@Override
	public void pushNegro(Object o) throws Exception {
		if(tn==S.length || tr == tn-1) {
			Object temp[] = new Object[S.length*2];	
			if(tr > -1){
				for(int i = 0; i<=tr; i++) {
					temp[i] = S[i];
				}
			}
			
			
							
			for(int i = temp.length-1; i >=tn; i--) {
				if(tn<= S.length-1) {
					temp[i] = S[tn];
					tn++;
				}else { //Quando o total de elementos [N] já estiverem no novo array e necessário atualizar o topo tn 
					tn = i+1;
					break;
				}
				
			}
			S = temp;
		}
		tn = tn!=1 ? tn-1 : tn;
		S[tn] = o;
		
	}
	@Override
	public Object popNegro() throws Exception {
		if(isEmpty())
			throw new Exception("Pilha vazia");
		
		Object temp = S[tn];
		S[tn] = null;
		tn = tn+1;
		return temp;
	}
	@Override
	public boolean isFull() {
		return tr-tn==1 ? true : false;
	}

	@Override
	public String toString() {
		return "[" + Arrays.toString(S) + "], tr=" + tr + ", tn=" + tn ;
	}

}
