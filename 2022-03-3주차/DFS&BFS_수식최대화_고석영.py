def solution(expression): 
    answer = 0
    operations = [('*', '+', '-'), 
                  ('*', '-', '+'),
                  ('+', '-', '*'),
                  ('+', '*', '-'),
                  ('-', '*', '+'),
                  ('-', '+', '*')]
    
    for oper in operations: 
        result = abs(int(calc(oper, 0, expression))) 
        if result > answer: 
            answer = result
            
    return answer

def calc(operation, seq, exp):
    if exp.isdigit(): 
        return str(exp) 
    else: 
        if operation[seq] == "*": 
            splitted = exp.split("*") 
            temp = []
            for s in splitted: 
                temp.append(calc(operation, seq+1, s)) 
            return str(eval("*".join(temp)))
        
        if operation[seq] == "+":
            splitted = exp.split("+")
            temp = []
            for s in splitted:
                temp.append(calc(operation, seq+1, s))
            return str(eval("+".join(temp)))
        
        if operation[seq] == "-":
            splitted = exp.split("-")
            temp = []
            for s in splitted:
                temp.append(calc(operation, seq+1, s))
            return str(eval("-".join(temp)))
