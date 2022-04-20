import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;

import java.io.IOException;

class Solution {

    public static void main(String[] args) throws IOException  {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        final int N = Integer.parseInt(br.readLine());
        // read() -> 문자를 숫자값으로 인식 ('0' -> 49)

        String[] numArr = br.readLine().split(" ");

        MyHashtable table = new MyHashtable(N);
        for (String s : numArr) {
            table.put(s, s);
        }

        final int M = Integer.parseInt(br.readLine());
        String[] numArr2 = br.readLine().split(" ");

        for (String s : numArr2) {
            System.out.println(table.get(s) != null ? 1 : 0);
        }
    }
}

/**
 * 해시테이블
 * => key, value로 데이터를 저장하는 자료구조
 * 
 * 해시테이블 구현
 * => key값에 해시함수를 적용해서 배열의 고유한 index 생성
 * => index를 활용해 값 저장, 검색
 * => key로 value를 찾기 때문에 빠르게 데이터를 검색할 수 있다
 * => 평균 O(1)의 시간복잡도 가짐
 *  
 * Java의 HashTable vs HashMap
 * HashTable : 병렬 프로그래밍할 때 동기화 지원 (synchronized)
 * HashMap : 동기화 지원 X
 * 
 * 참고 글 : https://d2.naver.com/helloworld/831311
 */
class MyHashtable {

    private LinkedList<Entry>[] table;

    public MyHashtable() {}

    // 충돌시 값을 연결하기 위해 LinkedList 배열로 생성
    public MyHashtable(int length) {
        this.table = new LinkedList[length];
    }
    
    // key와 value를 필드로 가지는 Entry클래스
    class Entry {
        String key;
        String value;
        
        public Entry() {}
        
        public Entry(String key, String value) {
            this.key = key;
            this.value = value;
        }

    }

    /**
     * hashing
     * 매개변수로 넘어온 문자열 key를 hashCode로 만드는 함수
     * 동일한 문자열은 동일한 hashCode를 가짐
     * 각 문자열마다 hashCode가 중복되지 않게 만들어 충돌을 최소화해야 함
     * 
     * @param key
     * @return hashCode
     */
    public int getHashCode(String key) {
        int hashCode = 0;

        for (char c : key.toCharArray()) {
            hashCode += hashCode * 31 + c;
        }

        return hashCode;
    }

    /**
     * hashCode를 배열의 길이로 나누어 각 key에 대한 index 할당
     * 배열의 길이가 10일때 10으로 나누면 나머지는 0~9 사이의 숫자가 나온다
     * 이런 식으로 배열의 index범위 내에서 index를 할당할 수 있다
     * 
     * @param hashCode
     * @return index
     */
    public int getIndex(int hashCode) {
        return Math.abs(hashCode % this.table.length);
    }

    /**
     * table의 해당 index자리에 저장된 entry가 2개 이상이면
     * index와 key로 entry를 찾는다
     * 
     * @param index
     * @param key
     * @return Entry (if not found return null)
     */
    public Entry searchEntry(int index, String key) {
        LinkedList<Entry> entryList = this.table[index];

        for (Entry e : entryList) {
            if (key.equals(e.key)) {
                return e;
            }
        }

        return null;
    }

    /**
     * key와 value값이 들어오면
     * key를 hashCode로 만들고
     * hashCode에 대한 index값을 구하고
     * 배열의 해당 index에 key와 value를 저장한다.
     * 
     * name의 hashCode와 mane의 hashCode처럼 hashCode가 같은 경우?
     * 충돌을 해결하기 위해 LinkedList에 Entry를 연결한다
     * 
     * @param key
     * @param value
     */
    public void put(String key, String value) {
        int hashCode = getHashCode(key);
        int index = getIndex(hashCode);

        if (this.table[index] != null) {
            this.table[index].add(new Entry(key, value));
        } else {
            LinkedList<Entry> entryList = new LinkedList<Entry>();
            entryList.add(new Entry(key, value));
            this.table[index] = entryList;
        }
        
    }

    /**
     * key로 value를 찾는다
     * 
     * @param key
     * @return value (if not found return null)
     */
    public String get(String key) {
        int hashCode = getHashCode(key);
        int index = getIndex(hashCode);

        String value = null;
        if (this.table[index] == null || this.table[index].isEmpty()) {
            // 해당 key에 매칭되는 index에 저장된 value가 없을때
            return null;
        } else if (this.table[index].size() == 1) { 
            // table의 해당 index자리에 저장된 entry가 1개면
            // 반복문을 거치지 않고 index를 통해 바로 value를 찾을 수 있다
            Entry e = this.table[index].get(0);
            value = key.equals(e.key) ? e.value : null;
        } else if (this.table[index].size() >= 2) { 
            // table의 해당 index자리에 저장된 entry가 2개 이상이면
            // index와 key로 entry를 찾는다
            Entry e = searchEntry(index, key);
            value = e != null ? e.value : null;
        }

        return value;
    }
}
