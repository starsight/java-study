package com.wenjiehe.JavaSE;


public class  CuckooHashTable<AnyType>{
	public CuckooHashTable(HashFamily<? super AnyType> hf){
		this(hf,DEFAULT_TABLE_SIZE);
	}

	public CuckooHashTable(HashFamily<? super AnyType> hf,int size){
		allocateArray(nextPrime(size));
		doClear();
		hashFunctions = hf;
		numHashFunctions = hf.getNumberOfFunctions();
	}

	public void makeEmpty(){
		currentSize = 0;
		for(int i=0;i<array.length;i++){
			array[i] = null;
		}
	}

	public boolean contain(){

	}

	private int myhash(AnyType x,int which){

	}

	private int findPos(AnyType x){

	}

	public  boolean remove(AnyType x){

	}

	public boolean insert(AnyType x){

	}

	private void expand(){

	}

	private void rehash(){

	}

	private void doClear(){

	}

	private void allocateArray(int arraysize){
		array = (AnyType[])new Object[arraysize];
	}

	private static final double MAX_LOAD = 0.4;
	private static final int ALLOWED_REHASHES = 1;
	private static final int DEFAULT_TABLE_SIZE =101;

	private final HashFamily<? super AnyType> hashFunctions;
	private final int numHashFunctions;
	private AnyType[] array;
	private int currentSize;

	/*public static <AnyType extends Comparable<? super AnyType>> void a(AnyType as){

	}*/
}