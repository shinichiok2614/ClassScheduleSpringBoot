//package algorithm;
//
//public class ClassByBit {
//    private String idBit;
//    private String roomBit;
//    private String courseBit;
//    private String instructorBit;
//    private String mtBit;
//
//    private Data data;
//
//    public ClassByBit(String idBit, String courseBit){
//        this.idBit = idBit;
//        this.courseBit = courseBit;
//    }
//
//
////	// to Binary String
////	public String toBinaryStr(int n, int length) {
////		String binaryStr = Integer.toBinaryString(n);
////		if (binaryStr.length() < length) {
////			int sub = length - binaryStr.length();
////			//Add sub bit(s) 0
////			for (int i = 0 ; i < sub; i++) {
////				binaryStr = "0" + binaryStr;
////			}
////		}
////		return binaryStr;
////	}
//
//    public String getIdBit() {
//        return idBit;
//    }
//    public String getRoomBit() {
//        return roomBit;
//    }
//    public String getCourseBit() {
//        return courseBit;
//    }
//    public String getInstructorBit() {
//        return instructorBit;
//    }
//    public String getMtBit() {
//        return mtBit;
//    }
//    public Data getData() {
//        return data;
//    }
//
//    public void setRoomBit(String roomBit) {
//        this.roomBit = roomBit;
//    }
//    public void setInstructorBit(String instructorBit) {
//        this.instructorBit = instructorBit;
//    }
//    public void setMtBit(String mtBit) {
//        this.mtBit = mtBit;
//    }
//
//    @Override
//    public String toString() {
//        return courseBit + roomBit + instructorBit + mtBit;
//    }
//}