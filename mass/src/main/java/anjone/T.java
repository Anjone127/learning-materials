package anjone;

import java.util.*;

public class T {
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		Integer n = in.nextInt(), l ,r;
		Segment[] list = new Segment[n];
		for(int i = 0 ; i < n ; i++){
			l = in.nextInt();
			r = in.nextInt();
			list[i] = new Segment(l,r,i+1);
		}
		Arrays.sort(list);
		for(int i = 0 ; i < n ; i++) {
			for(int j = i+1 ; j < n ; j++){
				if(list[i].getR() >= list[j].getR()){
					System.out.println(list[j].getIndex() + " " + list[i].getIndex());
					return;
				}else{
					break;
				}
			}
		}
		System.out.println("-1 -1");
	}
}

class Segment implements Comparable{
	private Integer l;
	private Integer r;
	private Integer index;

	Segment(Integer l , Integer r, Integer index){
		this.l = l;
		this.r = r;
		this.index = index;
	}

	public Integer getIndex() {
		return index;
	}

	public Integer getR() {
		return r;
	}

	@Override
	public int compareTo(Object o) {
		Segment segment = (Segment) o;
		if(this.l.equals(segment.l)) {
			return segment.r - this.r;
		}
		return this.l - segment.l;
	}
}