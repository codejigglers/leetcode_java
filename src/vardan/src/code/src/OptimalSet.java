package code.src;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Solution by Jeff Kirby. I wrote this after I was hired to evaluate the question and recent responses.
 *
 * Note that this doesn't truly find the "optimal set". For the given data it's good enough just to sort the combos
 * by discount and start by evaluating the combo with best discount.
 *
 * However it would easily be possible to construct an example where a thousand $1 discounts would be better than
 * one $500 discount. This would be pretty tough to code a solution for.
 */
public class OptimalSet {

}
