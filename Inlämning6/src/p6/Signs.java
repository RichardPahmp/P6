package p6;

public class Signs {
	
	public static final int[][] SPACE = {
			{0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0}};
	public static final int[][] DOT = {
			{0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0},
			{0,0,0,1,0,0,0}};
	public static final int[][] COMMA = {
			{0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0},
			{0,0,0,1,0,0,0},
			{0,0,1,0,0,0,0}};
	public static final int[][] COLON = {
			{0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0},
			{0,0,0,1,0,0,0},
			{0,0,0,0,0,0,0},
			{0,0,0,1,0,0,0},
			{0,0,0,0,0,0,0}};
	public static final int[][] SEMICOLON = {
			{0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0},
			{0,0,0,1,0,0,0},
			{0,0,0,0,0,0,0},
			{0,0,0,1,0,0,0},
			{0,0,1,0,0,0,0}};
	public static final int[][] EXCLAMATION_MARK = {
			{0,0,0,1,0,0,0},
			{0,0,0,1,0,0,0},
			{0,0,0,1,0,0,0},
			{0,0,0,1,0,0,0},
			{0,0,0,1,0,0,0},
			{0,0,0,0,0,0,0},
			{0,0,0,1,0,0,0}};
	public static final int[][] QUESTION_MARK = {
			{0,0,1,1,0,0,0},
			{0,1,0,0,1,0,0},
			{0,0,0,0,1,0,0},
			{0,0,0,0,1,0,0},
			{0,0,0,1,0,0,0},
			{0,0,0,0,0,0,0},
			{0,0,0,1,0,0,0}};
	public static final int[][] ZERO = {
			{0,0,1,1,1,0,0},
			{0,1,0,0,0,1,0},
			{0,1,0,0,0,1,0},
			{0,1,0,0,0,1,0},
			{0,1,0,0,0,1,0},
			{0,1,0,0,0,1,0},
			{0,0,1,1,1,0,0}};
	public static final int[][] ONE = {
			{0,0,0,1,0,0,0},
			{0,0,1,1,0,0,0},
			{0,0,0,1,0,0,0},
			{0,0,0,1,0,0,0},
			{0,0,0,1,0,0,0},
			{0,0,0,1,0,0,0},
			{0,0,1,1,1,0,0}};
	public static final int[][] TWO ={
			{0,0,1,1,0,0,0},
			{0,1,0,0,1,0,0},
			{0,1,0,0,1,0,0},
			{0,0,0,0,1,0,0},
			{0,0,0,1,0,0,0},
			{0,0,1,0,0,0,0},
			{0,1,1,1,1,1,0}};
	public static final int[][] THREE = {
			{0,0,1,1,0,0,0},
			{0,1,0,0,1,0,0},
			{0,0,0,0,1,0,0},
			{0,0,1,1,0,0,0},
			{0,0,0,0,1,0,0},
			{0,1,0,0,1,0,0},
			{0,0,1,1,0,0,0}};
	public static final int[][] FOUR = {
			{0,0,1,0,0,1,0},
			{0,0,1,0,0,1,0},
			{0,0,1,0,0,1,0},
			{0,0,1,1,1,1,0},
			{0,0,0,0,0,1,0},
			{0,0,0,0,0,1,0},
			{0,0,0,0,0,1,0}};
	public static final int[][] FIVE = {
			{0,0,1,1,1,1,0},
			{0,0,1,0,0,0,0},
			{0,0,1,0,0,0,0},
			{0,0,1,1,1,0,0},
			{0,0,0,0,0,1,0},
			{0,0,0,0,0,1,0},
			{0,0,1,1,1,0,0}};
	public static final int[][] SIX = {
			{0,0,1,1,1,0,0},
			{0,1,0,0,0,0,0},
			{0,1,0,0,0,0,0},
			{0,1,1,1,0,0,0},
			{0,1,0,0,1,0,0},
			{0,1,0,0,1,0,0},
			{0,0,1,1,0,0,0}};
	public static final int[][] SEVEN = {
			{0,1,1,1,1,0,0},
			{0,0,0,0,0,1,0},
			{0,0,0,0,0,1,0},
			{0,0,0,0,0,1,0},
			{0,0,0,0,0,1,0},
			{0,0,0,0,0,1,0},
			{0,0,0,0,0,1,0}};
	public static final int[][] EIGHT = {
			{0,0,1,1,1,0,0},
			{0,1,0,0,0,1,0},
			{0,1,0,0,0,1,0},
			{0,0,1,1,1,0,0},
			{0,1,0,0,0,1,0},
			{0,1,0,0,0,1,0},
			{0,0,1,1,1,0,0}};
	public static final int[][] NINE = {
			{0,0,1,1,1,1,0},
			{0,0,1,0,0,1,0},
			{0,0,1,0,0,1,0},
			{0,0,1,1,1,1,0},
			{0,0,0,0,0,1,0},
			{0,0,0,0,0,1,0},
			{0,0,0,0,0,1,0}};
	public static final int[][] A = {
			{0,0,0,1,0,0,0},
			{0,0,1,0,1,0,0},
			{0,0,1,0,1,0,0},
			{0,0,1,1,1,0,0},
			{0,1,0,0,0,1,0},
			{0,1,0,0,0,1,0},
			{0,1,0,0,0,1,0}};
	public static final int[][] B = {
			{0,1,1,1,0,0,0},
			{0,1,0,0,1,0,0},
			{0,1,0,0,1,0,0},
			{0,1,1,1,0,0,0},
			{0,1,0,0,1,0,0},
			{0,1,0,0,1,0,0},
			{0,1,1,1,0,0,0}};
	public static final int[][] C = {
			{0,0,0,1,1,1,0},
			{0,0,1,0,0,0,0},
			{0,1,0,0,0,0,0},
			{0,1,0,0,0,0,0},
			{0,1,0,0,0,0,0},
			{0,0,1,0,0,0,0},
			{0,0,0,1,1,1,0}};
	public static final int[][] D = {
			{0,1,1,1,0,0,0},
			{0,1,0,0,1,0,0},
			{0,1,0,0,0,1,0},
			{0,1,0,0,0,1,0},
			{0,1,0,0,0,1,0},
			{0,1,0,0,1,0,0},
			{0,1,1,1,0,0,0}};
	public static final int[][] E = {
			{0,1,1,1,1,0,0},
			{0,1,0,0,0,0,0},
			{0,1,0,0,0,0,0},
			{0,1,1,1,0,0,0},
			{0,1,0,0,0,0,0},
			{0,1,0,0,0,0,0},
			{0,1,1,1,1,0,0}};
	public static final int[][] F = {
			{0,0,1,1,1,1,0},
			{0,0,1,0,0,0,0},
			{0,0,1,0,0,0,0},
			{0,0,1,1,1,0,0},
			{0,0,1,0,0,0,0},
			{0,0,1,0,0,0,0},
			{0,0,1,0,0,0,0}};
	public static final int[][] G = {
			{0,0,1,1,1,0,0},
			{0,1,0,0,0,1,0},
			{0,1,0,0,0,0,0},
			{0,1,0,0,0,0,0},
			{0,1,0,1,1,1,0},
			{0,1,0,0,0,1,0},
			{0,0,1,1,1,0,0}};
	public static final int[][] H = {
			{0,1,0,0,0,1,0},
			{0,1,0,0,0,1,0},
			{0,1,0,0,0,1,0},
			{0,1,1,1,1,1,0},
			{0,1,0,0,0,1,0},
			{0,1,0,0,0,1,0},
			{0,1,0,0,0,1,0}};
	public static final int[][] I = {
			{0,0,1,1,1,0,0},
			{0,0,0,1,0,0,0},
			{0,0,0,1,0,0,0},
			{0,0,0,1,0,0,0},
			{0,0,0,1,0,0,0},
			{0,0,0,1,0,0,0},
			{0,0,1,1,1,0,0}};
	public static final int[][] J = {
			{0,0,1,1,1,1,0},
			{0,0,0,0,1,0,0},
			{0,0,0,0,1,0,0},
			{0,0,0,0,1,0,0},
			{0,1,0,0,1,0,0},
			{0,1,0,0,1,0,0},
			{0,0,1,1,1,0,0}};
	public static final int[][] K = {
			{0,1,0,0,0,1,0},
			{0,1,0,0,1,0,0},
			{0,1,0,1,0,0,0},
			{0,1,1,0,0,0,0},
			{0,1,0,1,0,0,0},
			{0,1,0,0,1,0,0},
			{0,1,0,0,0,1,0}};
	public static final int[][] L = {
			{0,1,0,0,0,0,0},
			{0,1,0,0,0,0,0},
			{0,1,0,0,0,0,0},
			{0,1,0,0,0,0,0},
			{0,1,0,0,0,0,0},
			{0,1,0,0,0,0,0},
			{0,1,1,1,1,0,0}};
	public static final int[][] M = {
			{1,0,0,0,0,0,1},
			{1,1,0,0,0,1,1},
			{1,0,1,0,1,0,1},
			{1,0,0,1,0,0,1},
			{1,0,0,0,0,0,1},
			{1,0,0,0,0,0,1},
			{1,0,0,0,0,0,1}};
	public static final int[][] N = {
			{1,0,0,0,0,0,1},
			{1,1,0,0,0,0,1},
			{1,0,1,0,0,0,1},
			{1,0,0,1,0,0,1},
			{1,0,0,0,1,0,1},
			{1,0,0,0,0,1,1},
			{1,0,0,0,0,0,1}};
	public static final int[][] O = {
			{0,0,1,1,1,0,0},
			{0,1,0,0,0,1,0},
			{1,0,0,0,0,0,1},
			{1,0,0,0,0,0,1},
			{1,0,0,0,0,0,1},
			{0,1,0,0,0,1,0},
			{0,0,1,1,1,0,0}};
	public static final int[][] P = {
			{0,1,1,1,1,0,0},
			{0,1,0,0,0,1,0},
			{0,1,0,0,0,1,0},
			{0,1,1,1,1,0,0},
			{0,1,0,0,0,0,0},
			{0,1,0,0,0,0,0},
			{0,1,0,0,0,0,0}};
	public static final int[][] Q = {
			{0,0,1,1,1,0,0},
			{0,1,0,0,0,1,0},
			{1,0,0,0,0,0,1},
			{1,0,0,0,0,0,1},
			{1,0,0,0,1,0,1},
			{0,1,0,0,0,1,0},
			{0,0,1,1,1,0,1}};
	public static final int[][] R = {
			{0,1,1,1,0,0,0},
			{0,1,0,0,1,0,0},
			{0,1,0,0,1,0,0},
			{0,1,1,1,0,0,0},
			{0,1,0,1,0,0,0},
			{0,1,0,0,1,0,0},
			{0,1,0,0,0,1,0}};
	public static final int[][] S = {
			{0,0,0,1,1,0,0},
			{0,0,1,0,0,1,0},
			{0,0,1,0,0,0,0},
			{0,0,0,1,1,0,0},
			{0,0,0,0,0,1,0},
			{0,0,1,0,0,1,0},
			{0,0,0,1,1,0,0}};
	public static final int[][] T = {
			{0,1,1,1,1,1,0},
			{0,0,0,1,0,0,0},
			{0,0,0,1,0,0,0},
			{0,0,0,1,0,0,0},
			{0,0,0,1,0,0,0},
			{0,0,0,1,0,0,0},
			{0,0,0,1,0,0,0}};
	public static final int[][] U = {
			{1,0,0,0,0,0,1},
			{1,0,0,0,0,0,1},
			{1,0,0,0,0,0,1},
			{1,0,0,0,0,0,1},
			{1,0,0,0,0,0,1},
			{0,1,0,0,0,1,0},
			{0,0,1,1,1,0,0}};
	public static final int[][] V = {
			{0,1,0,0,0,1,0},
			{0,1,0,0,0,1,0},
			{0,1,0,0,0,1,0},
			{0,1,0,0,0,1,0},
			{0,1,0,0,0,1,0},
			{0,0,1,0,1,0,0},
			{0,0,0,1,0,0,0}};
	public static final int[][] W = {
			{1,0,0,0,0,0,1},
			{1,0,0,0,0,0,1},
			{1,0,0,0,0,0,1},
			{1,0,0,0,0,0,1},
			{1,0,0,1,0,0,1},
			{0,1,0,1,0,1,0},
			{0,0,1,0,1,0,0}};
	public static final int[][] X = {
			{1,0,0,0,0,0,1},
			{0,1,0,0,0,1,0},
			{0,0,1,0,1,0,0},
			{0,0,0,1,0,0,0},
			{0,0,1,0,1,0,0},
			{0,1,0,0,0,1,0},
			{1,0,0,0,0,0,1}};
	public static final int[][] Y = {
			{0,1,0,0,0,1,0},
			{0,1,0,0,0,1,0},
			{0,1,0,0,0,1,0},
			{0,0,1,1,1,0,0},
			{0,0,0,1,0,0,0},
			{0,0,0,1,0,0,0},
			{0,0,0,1,0,0,0}};
	public static final int[][] Z = {
			{0,1,1,1,1,1,0},
			{0,0,0,0,0,1,0},
			{0,0,0,0,1,0,0},
			{0,0,0,1,0,0,0},
			{0,0,1,0,0,0,0},
			{0,1,0,0,0,0,0},
			{0,1,1,1,1,1,0}};

}
