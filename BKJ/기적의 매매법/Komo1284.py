cash = int(input())
prices = list(map(int, input().split()))

# BNP 전략 (그냥 살 수 있을 때마다 매수)
bnp_cash = cash
bnp_stocks = 0

for price in prices:
    if bnp_cash >= price:
        stocks_to_buy = bnp_cash // price
        bnp_cash -= stocks_to_buy * price
        bnp_stocks += stocks_to_buy

bnp_total = bnp_cash + bnp_stocks * prices[-1]

# 타이밍 전략 (3일 연속 상승/하락에 따른 매도/매수)
timing_cash = cash
timing_stocks = 0

for i in range(3, len(prices)):
    # 3일 연속 가격 하락 시 매수
    if prices[i - 3] > prices[i - 2] > prices[i - 1]:
        stocks_to_buy = timing_cash // prices[i]
        timing_cash -= stocks_to_buy * prices[i]
        timing_stocks += stocks_to_buy

    # 3일 연속 가격 상승 시 매도
    elif prices[i - 3] < prices[i - 2] < prices[i - 1]:
        timing_cash += timing_stocks * prices[i]
        timing_stocks = 0

timing_total = timing_cash + timing_stocks * prices[-1]

# 결과 출력
if bnp_total > timing_total:
    print("BNP")
elif bnp_total < timing_total:
    print("TIMING")
else:
    print("SAMESAME")